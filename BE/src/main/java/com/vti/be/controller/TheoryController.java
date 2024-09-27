package com.vti.be.controller;

import com.vti.be.dto.LessonDTO;
import com.vti.be.dto.TheoryDTO;
import com.vti.be.entity.Lesson;
import com.vti.be.entity.Theory;
import com.vti.be.service.ITheoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/theory")
@CrossOrigin("*")
public class TheoryController {
    @Autowired
    private ITheoryService theoryService;
    @Autowired
    private ModelMapper modelMapper;
//    @GetMapping()
//    public ResponseEntity<?> getAllTheory() {
//        List<Theory> entities = theoryService.getAllTheory();
//
//        List<TheoryDTO> dtos = new ArrayList<>();
//
//        // convert entities --> dtos
//        for (Theory entity : entities) {
//            TheoryDTO dto = new TheoryDTO(entity.getTheoryId(),entity.getTheoryName(),entity.getVideoUrl(),entity.getTextContent());
//            dtos.add(dto);
//        }
//
//        return new ResponseEntity<>(dtos, HttpStatus.OK);
//    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getTheoryById(@PathVariable(name = "id") Integer id){
        Theory theory = theoryService.getTheoryById(id);
        TheoryDTO theoryDTO = new TheoryDTO(theory.getTheoryId(),theory.getTheoryName(), theory.getVideoUrl(), theory.getTextContent()
                , theory.getLesson().getId(),theory.getLesson().getLessonName());
        return new ResponseEntity<TheoryDTO>(theoryDTO, HttpStatus.OK);
    }
//    public TheoryDTO getTheoryById(@PathVariable(name = "id") Integer id){
//        Theory theory = theoryService.getTheoryById(id);;//nhận từ bên dưới
//        return modelMapper.map(theory, TheoryDTO.class);//map sang DTO
//
//    }
}
