package com.vti.be.dto;

import lombok.Data;

@Data
public class OrderItemDTO {
    private Long id;
    private Integer orderId;
    private Integer productId;
    private Integer quantity;
    private String type;
    private double price;
}
