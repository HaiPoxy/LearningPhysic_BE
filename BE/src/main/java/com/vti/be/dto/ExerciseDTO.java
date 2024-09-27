package com.vti.be.dto;

import com.vti.be.entity.Lesson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ExerciseDTO {
    private Integer exerciseId;
    private String exerciseName;
    //private Lesson lesson;
    private Integer lessonId;
    private String lessonName;
    //private List<QuestionDTO> questions;

//    @Getter
//    @Setter
//    @NoArgsConstructor
//    public static class QuestionDTO{
//        private Integer questionId;
//        private String questionName;
//        private String optionA;
//        private String optionB;
//        private String optionC;
//        private String optionD;
//        private String correctAnswer;
//    }

    public ExerciseDTO(Integer exerciseId, String exerciseName, Integer lessonId, String lessonName) {
        this.exerciseId = exerciseId;
        this.exerciseName = exerciseName;
        this.lessonId = lessonId;
        this.lessonName = lessonName;
    }


//    public ExerciseDTO(Integer exerciseId, String exerciseName, Integer lessonId, String lessonName, List<QuestionDTO> questions) {
//        this.exerciseId = exerciseId;
//        this.exerciseName = exerciseName;
//        this.lessonId = lessonId;
//        this.lessonName = lessonName;
//        this.questions = questions;
//    }
}
