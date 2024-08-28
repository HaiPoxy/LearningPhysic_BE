package com.vti.be.dto;

import lombok.Data;

@Data
public class FavoritePostDTO {
    private Integer id;
    private Integer accountId;
    private Integer postId;
}