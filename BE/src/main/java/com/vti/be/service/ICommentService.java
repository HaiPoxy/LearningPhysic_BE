package com.vti.be.service;

import com.vti.be.dto.CommentDTO;
import com.vti.be.form.CommentCreateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICommentService {
    Page<CommentDTO> getAllComments(Pageable pageable);

    CommentDTO createComment(CommentCreateForm commentDTO);

    CommentDTO updateComment(Integer id, CommentDTO updatedCommentDTO) throws Exception;

    void deleteCommentById(Integer id) throws Exception;

    Optional<CommentDTO> findCommentById(Integer id);
}
