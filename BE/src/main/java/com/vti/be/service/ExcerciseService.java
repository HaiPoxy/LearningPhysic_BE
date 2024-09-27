package com.vti.be.service;

import com.vti.be.entity.Exercise;
import com.vti.be.repository.IEbookRepository;
import com.vti.be.repository.IExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcerciseService implements IExerciseSevice {
    @Autowired
    private IExerciseRepository exerciseRepository;
    @Override
    public Exercise getExerciseById(Integer id) {
        return exerciseRepository.getById(id);
    }

    @Override
    public List<Exercise> getAllExercise() {
        return exerciseRepository.findAll();
    }
}
