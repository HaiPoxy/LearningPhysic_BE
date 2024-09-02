package com.vti.be.repository;

import com.vti.be.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILessonRepository extends JpaRepository<Lesson,Integer> {
}
