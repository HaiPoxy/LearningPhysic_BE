package com.vti.be.dto;

import com.vti.be.entity.Lesson;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class CourseDTO {
  private Integer id;
  private String courseName;
  private String description;
  private BigDecimal price = BigDecimal.valueOf(0.00);
  private boolean isFree = false;
  private String classLevel;
  private String imageUrl;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private List<Lesson> lessons;
}