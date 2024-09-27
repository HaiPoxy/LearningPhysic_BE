package com.vti.be.service;

import com.vti.be.entity.Theory;
import com.vti.be.repository.ITheoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheoryService implements  ITheoryService{
    @Autowired
    private ITheoryRepository theoryRepository;
    @Override
    public Theory getTheoryById(Integer id) {
        return theoryRepository.getById(id);
    }

    @Override
    public List<Theory> getAllTheory() {
        return theoryRepository.findAll();
    }
}
