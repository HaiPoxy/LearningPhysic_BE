package com.vti.be.controller;

import com.vti.be.dto.QuestionDTO;
import com.vti.be.dto.TheoryDTO;
import com.vti.be.entity.Question;
import com.vti.be.entity.Theory;
import com.vti.be.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/question")
@CrossOrigin("*")
public class QuestionController {
    @Autowired
    private IQuestionService questionService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getQuestionById(@PathVariable(name = "id") Integer id){
        Question question = questionService.getQuestionById(id);
        QuestionDTO questionDTO = new QuestionDTO(question.getQuestionId(),question.getQuestionName(), question.getOptionA(),question.getOptionB(),question.getOptionC(),
                question.getOptionD(),question.getCorrectAnswer(),question.getExercise().getExerciseId());
        return new ResponseEntity<QuestionDTO>(questionDTO, HttpStatus.OK);
    }
}
