package com.vti.be.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * -- Lưu trữ thông tin về các lần làm bài thi của người dùng, cho phép xem lại kết quả và đáp án.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserExamAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attemptId;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;

    private Integer score;

    @CreationTimestamp
    private LocalDateTime attemptDate;

    private String answers; // Store answers as JSON

    private String feedback;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
