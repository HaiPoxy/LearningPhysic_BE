package com.vti.be.service;

import java.util.List;

import com.vti.be.dto.CourseDTO;

public interface ICourseService {
  List<CourseDTO> getAllCourses();

  CourseDTO getCourseById(Integer id);

  CourseDTO createCourse(CourseDTO courseDTO);

  CourseDTO updateCourse(Integer id, CourseDTO courseDTO);

  void deleteCourse(Integer id);
}