package com.vti.be.controller;

import com.vti.be.dto.CourseDTO;
import com.vti.be.dto.LessonDTO;
import com.vti.be.entity.Course;
import com.vti.be.entity.Lesson;
import com.vti.be.service.ILessonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/lesson")
@CrossOrigin("*")
public class LessonController {
    @Autowired
    private ILessonService lessonService;
    @Autowired
    private ModelMapper modelMapper;
//    @GetMapping()
//    public ResponseEntity<?> getAllLesson() {
//        List<Lesson> entities = lessonService.getAllLesson();
//
//        List<LessonDTO> dtos = new ArrayList<>();
//
//        // convert entities --> dtos
//        for (Lesson entity : entities) {
//            LessonDTO dto = new LessonDTO(entity.getId(),entity.getChapterName(),
//                    entity.getLessonName());
//            dtos.add(dto);
//        }
//
//        return new ResponseEntity<>(dtos, HttpStatus.OK);
//    }

    @GetMapping(value = "/{id}")
//    public ResponseEntity<?> getLessonById(@PathVariable(name = "id") Integer id){
//        Lesson lesson = lessonService.getLessonById(id);
//        LessonDTO lessonDTO = new LessonDTO(lesson.getId(),lesson.getChapterName(),
//                lesson.getLessonName());
//        return new ResponseEntity<LessonDTO>(lessonDTO, HttpStatus.OK);
//    }

    public LessonDTO getLessonById(@PathVariable int id){
        Lesson lesson = lessonService.getLessonById(id); ;//nhận từ bên dưới
        return modelMapper.map(lesson, LessonDTO.class);//map sang DTO

    }
}
