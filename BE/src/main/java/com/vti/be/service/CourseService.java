package com.vti.be.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.vti.be.dto.CourseDTO;
import com.vti.be.entity.Course;
import com.vti.be.repository.ICourseRepository;

@Service
public class CourseService implements ICourseService {

  private final ICourseRepository courseRepository;
  private final ModelMapper modelMapper;

  public CourseService(ICourseRepository courseRepository, ModelMapper modelMapper) {
    this.courseRepository = courseRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public List<CourseDTO> getAllCourses() {
    List<Course> courses = courseRepository.findAll();
    return courses.stream()
        .map(course -> modelMapper.map(course, CourseDTO.class))
        .collect(Collectors.toList());
  }

  @Override
  public CourseDTO getCourseById(Integer id) {
    Course course = courseRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Course not found with id: " + id));
    return modelMapper.map(course, CourseDTO.class);
  }

  @Override
  public CourseDTO createCourse(CourseDTO courseDTO) {
    Course course = modelMapper.map(courseDTO, Course.class);
    Course savedCourse = courseRepository.save(course);
    return modelMapper.map(savedCourse, CourseDTO.class);
  }

  @Override
  public CourseDTO updateCourse(Integer id, CourseDTO courseDTO) {
    Course existingCourse = courseRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Course not found with id: " + id));
    modelMapper.map(courseDTO, existingCourse);
    Course updatedCourse = courseRepository.save(existingCourse);
    return modelMapper.map(updatedCourse, CourseDTO.class);
  }

  @Override
  public void deleteCourse(Integer id) {
    if (!courseRepository.existsById(id)) {
      throw new IllegalArgumentException("Course not found with id: " + id);
    }
    courseRepository.deleteById(id);
  }
}
