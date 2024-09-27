package com.vti.be.service;

import com.vti.be.entity.Lesson;
import com.vti.be.repository.ILessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService implements ILessonService {
    @Autowired
    private ILessonRepository lessonRepository;

    @Override
    public Lesson getLessonById(Integer id) {
        return lessonRepository.getById(id);
    }

    @Override
    public List<Lesson> getAllLesson() {
        return lessonRepository.findAll();
    }
}
