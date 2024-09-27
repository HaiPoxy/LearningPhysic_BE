package com.vti.be.service;

import com.vti.be.entity.Course;
import com.vti.be.entity.Lesson;

import java.util.List;

public interface ILessonService {
    public Lesson getLessonById (Integer id);
    public List<Lesson> getAllLesson();

}
