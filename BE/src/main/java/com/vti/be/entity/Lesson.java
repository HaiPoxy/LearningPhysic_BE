package com.vti.be.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

/**
 * -- Quản lý các bài học trong mỗi khóa học.
 */
@Entity
@Data
@NoArgsConstructor
public class Lesson {
    @Column(name = "lesson_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private Course course;

    @OneToMany(mappedBy = "lesson")
    private List<Exercise> exercises;


    @OneToMany(mappedBy = "lesson")
    private List<Theory> theories;

    @Column(name = "chapter_name")
    private String chapterName;

    @Column(name = "lesson_name")
    private String lessonName;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt ;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;


}
