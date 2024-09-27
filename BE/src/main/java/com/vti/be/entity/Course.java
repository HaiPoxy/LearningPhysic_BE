package com.vti.be.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
//@Table(name = "Courses")
public class Course {
    @Column(name = "course_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "`description`")
    private String description;

    @Column(name = "price")
    private BigDecimal price = BigDecimal.valueOf(0.00);

    @Column(name = "is_free")
    private boolean isFree = false;

    @Column(name = "class_level")
    private String classLevel;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt ;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt ;

    @OneToMany(mappedBy = "course")
    private List<Lesson> lessons ;
}
