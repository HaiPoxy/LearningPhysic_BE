package com.vti.be.controller;

import com.vti.be.dto.ExerciseDTO;
import com.vti.be.dto.LessonDTO;
import com.vti.be.dto.TheoryDTO;
import com.vti.be.entity.Exercise;
import com.vti.be.entity.Lesson;
import com.vti.be.entity.Theory;
import com.vti.be.service.IExerciseSevice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/exercise")
@CrossOrigin("*")
public class ExcerciseController {
    @Autowired
    private IExerciseSevice exerciseSevice;
    @Autowired
    private ModelMapper modelMapper;
//    @GetMapping()
//    public ResponseEntity<?> getAllExercise() {
//        List<Exercise> entities = exerciseSevice.getAllExercise();
//
//        List<ExerciseDTO> dtos = new ArrayList<>();
//
//        // convert entities --> dtos
//        for (Exercise entity : entities) {
//            ExerciseDTO dto = new ExerciseDTO(entity.getExerciseId(),entity.getExerciseName(),entity.getQuestion(),entity.getAnswer());
//            dtos.add(dto);
//        }
//
//        return new ResponseEntity<>(dtos, HttpStatus.OK);
//    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getExerciseById(@PathVariable(name = "id") Integer id){
        Exercise exercise = exerciseSevice.getExerciseById(id);
        ExerciseDTO exerciseDTO = new ExerciseDTO(exercise.getExerciseId(),exercise.getExerciseName(),
                exercise.getLesson().getId(),exercise.getLesson().getLessonName());
        return new ResponseEntity<ExerciseDTO>(exerciseDTO, HttpStatus.OK);
    }
//    public ExerciseDTO getExerciseById(@PathVariable int id){
//        Exercise exercise = exerciseSevice.getExerciseById(id) ; ;//nhận từ bên dưới
//        return modelMapper.map(exercise, ExerciseDTO.class);//map sang DTO
//
//    }
}
