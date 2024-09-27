package com.vti.be.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QuestionDTO {
    private Integer questionId;
    private String questionName;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctAnswer;
    private Integer exerciseId;

    public QuestionDTO(Integer questionId, String questionName, String optionA, String optionB, String optionC, String optionD, String correctAnswer, Integer exerciseId) {
        this.questionId = questionId;
        this.questionName = questionName;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
        this.exerciseId = exerciseId;
    }
}
