package com.vti.be.dto;

import com.vti.be.entity.Account;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CommentDTO {
    private Integer id;
    private String content;
    private Integer postId;
    private Integer accountId ;
    private String fullName ;
    private Integer parentCommentId;
    private List<CommentDTO> childComments;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String status;
}
