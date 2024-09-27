package com.vti.be.service;

import com.vti.be.entity.Exercise;
import com.vti.be.entity.Theory;

import java.util.List;

public interface IExerciseSevice {
    public Exercise getExerciseById (Integer id);
    public List<Exercise> getAllExercise();
}
