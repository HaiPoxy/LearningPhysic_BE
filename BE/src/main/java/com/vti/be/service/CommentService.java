package com.vti.be.service;

import com.vti.be.dto.CommentDTO;
import com.vti.be.entity.Comment;
import com.vti.be.entity.Post;
import com.vti.be.form.CommentCreateForm;
import com.vti.be.repository.CommentRepository;
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

            // Recursively map child comments to CommentDTOs
            if (comment.getChildComments() != null && !comment.getChildComments().isEmpty()) {
                List<CommentDTO> childCommentDTOs = comment.getChildComments().stream()
                        .map(commentchild ->  modelMapper.map(commentchild, CommentDTO.class))
                        .collect(Collectors.toList());
                commentDTO.setChildComments(childCommentDTOs);
            }
//            else commentDTO.setChildComments(new ArrayList<CommentDTO>());
            // Set post ID if available
            if (comment.getPost() != null && comment.getPost().getId() != null) {
                commentDTO.setPostId(comment.getPost().getId());
            }
            return commentDTO;
        });
    }



    @Override
    public CommentDTO createComment(CommentCreateForm commentDTO) {
        // Convert CommentDTO to Comment entity
        Comment comment = modelMapper.map(commentDTO, Comment.class);

        // If parentCommentId is provided, find the parent comment and set it
        if (commentDTO.getParentCommentId() != null) {
            Optional<Comment> parentCommentOptional = commentRepository.findById(commentDTO.getParentCommentId());
            if (parentCommentOptional.isPresent()) {
                Comment parentComment = parentCommentOptional.get();
                comment.setCommentParent(parentComment);

                // Add the new comment to the childComments list of the parent
                parentComment.getChildComments().add(comment);

                // Save the parent comment to update the childComments list
                commentRepository.save(parentComment);
            } else {
                throw new IllegalArgumentException("Parent comment with ID " + commentDTO.getParentCommentId() + " not found.");
            }
        }
        else
        if(commentDTO.getPostId() != null ) {
            Optional<Post> post = postRepository.findById(commentDTO.getPostId()) ;
            if(post.isPresent()) {
                Post postSaved = post.get() ;
               postSaved.getComments().add(comment);

               postRepository.save(postSaved) ;
               comment.setPost(postSaved);
            }else {
                throw new IllegalArgumentException("Post with ID " + commentDTO.getPostId()  + " not found.");
            }
        }
        // Save the new comment
        Comment createdComment = commentRepository.save(comment);

        // Return the newly created comment as a CommentDTO
        CommentDTO savedComment = modelMapper.map(createdComment, CommentDTO.class);
        if (createdComment.getPost() != null && createdComment.getPost().getId() != null) {
            savedComment.setPostId(createdComment.getPost().getId());
        }
        return savedComment ;
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
