package com.vti.be.service;

import com.vti.be.dto.CommentDTO;
import com.vti.be.entity.Comment;
import com.vti.be.entity.Post;
import com.vti.be.form.CommentCreateForm;
import com.vti.be.repository.CommentRepository;
import com.vti.be.repository.IAccountRepository;
import com.vti.be.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository ;
    @Autowired
    private IAccountRepository accountRepository ;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<CommentDTO> getAllComments(Pageable pageable) {
        // Retrieve all comments as a Page
        Page<Comment> comments = commentRepository.findAll(pageable);

        // Filter to include only top-level comments
        List<Comment> filteredComments = comments.stream()
                .filter(comment -> comment.getCommentParent() == null)
                .collect(Collectors.toList());

        // Create a new Page object from the filtered list
        Page<Comment> filteredPage = new PageImpl<>(filteredComments, pageable, filteredComments.size());

        // Map each filtered Comment entity to a CommentDTO
        return filteredPage.map(comment -> {
            CommentDTO commentDTO = modelMapper.map(comment, CommentDTO.class);


            if (comment.getPost() != null) {
                commentDTO.setPostId(comment.getPost().getId());
            }
            // Recursively map child comments to CommentDTOs
            if (comment.getChildComments() != null && !comment.getChildComments().isEmpty()) {
                List<CommentDTO> childCommentDTOs = comment.getChildComments().stream()
                        .map(commentchild ->  {
                            CommentDTO commentchilddto =   modelMapper.map(commentchild, CommentDTO.class);
                            commentchilddto.setParentCommentId(commentchild.getCommentParent().getId());

                            commentchilddto.setPostId(comment.getPost().getId());
                            return commentchilddto ;
                        })
                        .collect(Collectors.toList());
                commentDTO.setChildComments(childCommentDTOs);
            }
//            else commentDTO.setChildComments(new ArrayList<CommentDTO>());
            // Set post ID if available

            return commentDTO;
        });
    }



    @Override
    public CommentDTO createComment(CommentCreateForm commentDTO) {
        // Map the incoming DTO to the Comment entity
        Comment comment = modelMapper.map(commentDTO, Comment.class);

        // Set the account for the comment
        comment.setAccount(accountRepository.findById(commentDTO.getAccountId()).orElseThrow(
                () -> new IllegalArgumentException("Account with ID " + commentDTO.getAccountId() + " not found.")
        ));

        // Check if the comment has a parent comment
        if (commentDTO.getParentCommentId() != null) {
            // Find the parent comment and set the relationship
            Comment parentComment = commentRepository.findById(commentDTO.getParentCommentId()).orElseThrow(
                    () -> new IllegalArgumentException("Parent comment with ID " + commentDTO.getParentCommentId() + " not found.")
            );
            comment.setCommentParent(parentComment);
        }

        // Check if the comment belongs to a post
        if (commentDTO.getPostId() != null) {
            // Find the post and set the relationship
            Post post = postRepository.findById(commentDTO.getPostId()).orElseThrow(
                    () -> new IllegalArgumentException("Post with ID " + commentDTO.getPostId() + " not found.")
            );
            comment.setPost(post);
        } else {
            throw new IllegalArgumentException("Post not found.");
        }

        // Save the comment only once after all relationships are set
        Comment createdComment = commentRepository.save(comment);

        // Map the created comment back to DTO
        CommentDTO savedComment = modelMapper.map(createdComment, CommentDTO.class);
        savedComment.setPostId(createdComment.getPost().getId());

        // Set parent comment ID in DTO if it exists
        if (createdComment.getCommentParent() != null) {
            savedComment.setParentCommentId(createdComment.getCommentParent().getId());
        }

        // Set account details in the DTO
        savedComment.setAccountId(createdComment.getAccount().getId());
        savedComment.setFullName(createdComment.getAccount().getFullName());

        return savedComment;
    }

    @Override
    public CommentDTO updateComment(Integer id, CommentDTO updatedCommentDTO) throws Exception {
        Optional<Comment> existingComment = commentRepository.findById(id);
        if (existingComment.isPresent()) {
            Comment comment = existingComment.get();
            modelMapper.map(updatedCommentDTO, comment);
            Comment updatedComment = commentRepository.save(comment);
            return modelMapper.map(updatedComment, CommentDTO.class);
        } else {
            throw new Exception("Comment with id " + id + " not found.");
        }
    }

    @Override
    public void deleteCommentById(Integer id) throws Exception {
        if (commentRepository.existsById(id)) {
            commentRepository.deleteById(id);
        } else {
            throw new Exception("Comment with id " + id + " not found.");
        }
    }

    @Override
    public Optional<CommentDTO> findCommentById(Integer id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.map(value -> modelMapper.map(value, CommentDTO.class));
    }
}
