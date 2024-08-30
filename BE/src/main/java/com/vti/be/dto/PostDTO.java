package com.vti.be.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PostDTO {
    private Integer id;
    private String title;
    private String content;
    private int numberLike;
    private int grade ;
    private String status;
    private Integer accountId;
    private String email ;
    private String fullName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<CommentDTO> comments;
}