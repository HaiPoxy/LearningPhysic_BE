package com.vti.be.service;


import com.vti.be.entity.Comment;
import com.vti.be.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Page<Comment> getAllComments(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    @Override
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Integer id, Comment updatedComment) throws Exception {
        Optional<Comment> existingComment = commentRepository.findById(id);
        if (existingComment.isPresent()) {
            Comment comment = existingComment.get();
            comment.setContent(updatedComment.getContent());
            comment.setCommentParent(updatedComment.getCommentParent());
            comment.setPost(updatedComment.getPost());
            return commentRepository.save(comment);
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
    public Optional<Comment> findCommentById(Integer id) {
        return commentRepository.findById(id);
    }
}