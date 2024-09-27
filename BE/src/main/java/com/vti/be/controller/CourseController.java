package com.vti.be.controller;

import com.vti.be.dto.CourseDTO;
import com.vti.be.entity.Course;
import com.vti.be.entity.Lesson;
import com.vti.be.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/course")
@CrossOrigin("*")
public class CourseController {
@Autowired
private ICourseService courseService;
@Autowired
private ModelMapper modelMapper;
    @GetMapping(value = "/{id}")
//    public ResponseEntity<?> getCourseById(@PathVariable(name = "id") Integer id){
//        Course course = courseService.getCourseById(id);
//        CourseDTO courseDTO = new CourseDTO(course.getId(), course.getCourseName(), course.getDescription());
//        return new ResponseEntity<CourseDTO>(courseDTO, HttpStatus.OK);
//    }
    public CourseDTO getCourseById(@PathVariable int id){
        Course course  = courseService.getCourseById(id) ;//nhận từ bên dưới
        return modelMapper.map(course, CourseDTO.class);//map sang DTO

    }


}
