package com.vti.be.controller;

import com.vti.be.dto.CourseDTO;
import com.vti.be.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

  private final CourseService courseService;

  public CourseController(CourseService courseService) {
    this.courseService = courseService;
  }

  @GetMapping
  public ResponseEntity<List<CourseDTO>> getAllCourses() {
    List<CourseDTO> courses = courseService.getAllCourses();
    return ResponseEntity.ok(courses);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CourseDTO> getCourseById(@PathVariable Integer id) {
    CourseDTO course = courseService.getCourseById(id);
    return ResponseEntity.ok(course);
  }

  @PostMapping
  public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO) {
    CourseDTO createdCourse = courseService.createCourse(courseDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdCourse);
  }

  @PutMapping("/{id}")
  public ResponseEntity<CourseDTO> updateCourse(@PathVariable Integer id, @RequestBody CourseDTO courseDTO) {
    CourseDTO updatedCourse = courseService.updateCourse(id, courseDTO);
    return ResponseEntity.ok(updatedCourse);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCourse(@PathVariable Integer id) {
    courseService.deleteCourse(id);
    return ResponseEntity.noContent().build();
  }
}