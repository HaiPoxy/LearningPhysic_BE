package com.vti.be.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Theory {
    @Column(name = "theory_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theoryId;

    @Column(name = "theory_name")
    private String theoryName;

    @Column(name = "video_url")
    private String videoUrl;

    @Column(name = "text_content")
    private String textContent;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
}
