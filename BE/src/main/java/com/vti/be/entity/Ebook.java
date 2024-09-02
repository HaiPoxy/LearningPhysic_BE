package com.vti.be.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * -- Quản lý thông tin sách.
 */
@Entity
@Data
public class Ebook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ebookId;

    private String title;

    private String author;

    private String category;

    private String description;

    private BigDecimal price = BigDecimal.valueOf(0.00);

    private boolean isFree = false;

    private String ebookUrl;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
