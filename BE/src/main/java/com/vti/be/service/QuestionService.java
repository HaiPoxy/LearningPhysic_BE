package com.vti.be.service;

import com.vti.be.entity.Question;
import com.vti.be.repository.IQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService implements IQuestionService{
    @Autowired
    private IQuestionRepository questionRepository;
    @Override
    public Question getQuestionById(Integer id) {
        return questionRepository.getById(id);
    }
}
