package com.vti.be.service;

import com.vti.be.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICommentService {
    Page<Comment> getAllComments(Pageable pageable);

    Comment createComment(Comment comment);

    Comment updateComment(Integer id, Comment updatedComment) throws Exception;

    void deleteCommentById(Integer id) throws Exception;

    Optional<Comment> findCommentById(Integer id);
}
