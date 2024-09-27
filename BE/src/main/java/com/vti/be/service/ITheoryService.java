package com.vti.be.service;

import com.vti.be.entity.Lesson;
import com.vti.be.entity.Theory;

import java.util.List;

public interface ITheoryService {
    public Theory getTheoryById (Integer id);
    public List<Theory> getAllTheory();
}
