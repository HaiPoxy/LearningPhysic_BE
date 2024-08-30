package com.vti.be.form;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CommentCreateForm {
    private String content;
    private Integer postId;
    private Integer parentCommentId;
    private List<Integer> childCommentIds;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String status;
}
