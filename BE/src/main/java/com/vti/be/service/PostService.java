package com.vti.be.service;

import com.vti.be.dto.CommentDTO;
import com.vti.be.dto.PostDTO;
import com.vti.be.entity.Account;
import com.vti.be.entity.Post;
import com.vti.be.form.PostFilterForm;
import com.vti.be.repository.IAccountRepository;
import com.vti.be.repository.PostRepository;
import com.vti.be.specification.PostSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        Post post = modelMapper.map(postDTO, Post.class);

        if (postDTO.getAccountId() != null) {
            Account account = accountRepository.findById(postDTO.getAccountId())
                    .orElseThrow(() -> new RuntimeException("Account with id " + postDTO.getAccountId() + " not found."));
            post.setAccount(account);
        }

        post.setCreatedAt(LocalDateTime.now());

        Post savedPost = postRepository.save(post);

        PostDTO postSaved = modelMapper.map(savedPost, PostDTO.class);
        postSaved.setAccountId(savedPost.getAccount().getId());
        postSaved.setEmail(savedPost.getAccount().getEmail());
        postSaved.setFullName(savedPost.getAccount().getFullName());
        postSaved.setComments(savedPost.getAccount().getComments().stream().map(comment -> modelMapper.map(comment, CommentDTO.class)).toList());
        return postSaved ;
    }

    @Override
    public Page<PostDTO> getAllPosts(PostFilterForm form, Pageable pageable) {
        Page<Post> postPage;
        Specification<Post> spec = PostSpecification.buildSpec(form);

        switch (form.getType()) {
            case 0:
                // Return all posts without additional filtering
                postPage = postRepository.findAll(pageable);
                break;
            case 1:
                // Find posts sorted by number of likes in descending order with grade filtering
                Sort sort = Sort.by("numberLike").descending();
                Pageable pageable1 = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
                postPage = postRepository.findAll(spec, pageable1);
                break;
            case 2:
                // Find unanswered posts with grade filtering and status = ACTIVE
                postPage = postRepository.findAll(spec, pageable);
                break;
            case 3:
                // Find posts by the current user with grade filtering
                postPage = postRepository.findAll(spec, pageable);
                break;
            case 4:
                // Find posts saved by the current user with grade filtering
                postPage = postRepository.findAll(spec, pageable);
                break;
            default:
                postPage = postRepository.findAll(pageable);
        }


        return postPage.map(post -> {
            PostDTO postDTO = modelMapper.map(post, PostDTO.class);

            postDTO.setAccountId(post.getAccount().getId());
            postDTO.setFullName(post.getAccount().getFullName());
            postDTO.setEmail(post.getAccount().getEmail());
            postDTO.setAvatarLink(post.getAccount().getAvatarLink());

            postDTO.setComments(post.getComments().stream()
                    .filter(comment -> comment.getCommentParent() == null)
                    .map(comment -> {
                        CommentDTO commentDTO = modelMapper.map(comment, CommentDTO.class);

                        // Recursively map child comments to CommentDTOs
                        if (comment.getChildComments() != null && !comment.getChildComments().isEmpty()) {
                            List<CommentDTO> childCommentDTOs = comment.getChildComments().stream()
                                    .map(commentchild -> {
                                        CommentDTO commentchilddto = modelMapper.map(commentchild, CommentDTO.class);
                                        commentchilddto.setParentCommentId(commentchild.getCommentParent().getId());
                                        commentchilddto.setPostId(comment.getPost().getId());
                                        commentchilddto.setAccountId(commentchild.getAccount().getId());
                                        commentchilddto.setFullName(commentchild.getAccount().getFullName());
                                        return commentchilddto;
                                    })
                                    .collect(Collectors.toList());
                            commentDTO.setChildComments(childCommentDTOs);
                        }
//            else commentDTO.setChildComments(new ArrayList<CommentDTO>());
                        // Set post ID if available
                        if (comment.getPost() != null) {
                            commentDTO.setPostId(comment.getPost().getId());
                        }
                        commentDTO.setAccountId(comment.getAccount().getId());
                        commentDTO.setFullName(comment.getAccount().getFullName());
                        return commentDTO;
                    }).toList());
            return postDTO;
        });
    }

    @Override
    public PostDTO updatePost(Integer id, PostDTO postDTO) {
        Optional<Post> existingPostOpt = postRepository.findById(id);
        if (existingPostOpt.isPresent()) {
            Post post = existingPostOpt.get();
            // Update only the fields that can be changed
            post.setTitle(postDTO.getTitle());
            post.setContent(postDTO.getContent());
            post.setNumberLike(postDTO.getNumberLike());
            post.setStatus(Post.postStatus.valueOf(postDTO.getStatus()));
            // You might want to update other fields as well

            Post updatedPost = postRepository.save(post);
            return modelMapper.map(updatedPost, PostDTO.class);
        } else {
            throw new RuntimeException("Post with id " + id + " not found.");
        }
    }

    @Override
    public void deletePostById(Integer id) {
        postRepository.deleteById(id);
    }

    @Override
    public Optional<PostDTO> findPostById(Integer id) {
        return postRepository.findById(id)
                .map(post -> modelMapper.map(post, PostDTO.class));
    }
}
