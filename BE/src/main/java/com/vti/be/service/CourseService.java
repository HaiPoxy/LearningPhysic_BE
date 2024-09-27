package com.vti.be.service;

import com.vti.be.entity.Course;
import com.vti.be.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService implements ICourseService{
    @Autowired
    private ICourseRepository courseRepository;
    @Override
    public Course getCourseById(Integer id) {
        return courseRepository.getById(id);
    }
}
