package com.vti.be.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDTO {
    private Integer id;
    private String content;
    private Integer postId;
    private Integer parentCommentId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}