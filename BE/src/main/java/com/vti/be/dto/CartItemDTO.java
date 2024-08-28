package com.vti.be.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CartItemDTO {
    private Integer id;
    private Integer accountId;
    private Integer productId;
    private int quantity;
    private double price;
    private String type;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String status;
}
