package com.vti.be.dto;

import com.vti.be.entity.Course;
import com.vti.be.entity.Exercise;
import com.vti.be.entity.Theory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class LessonDTO {
    private Integer id;
    //private Course course;
    private String chapterName;
    private String lessonName;
    private List<TheoryDTO> theories;
    private List<ExerciseDTO> exercises;
    private Integer courseId;
    private String courseName;


    @Getter
    @Setter
    @NoArgsConstructor
    public static class TheoryDTO{
        private Integer theoryId;
        private String theoryName;
        private String videoUrl;
        private String textContent;
    }
    @Getter
    @Setter
    @NoArgsConstructor
    public static class ExerciseDTO{
        private Integer exerciseId;
        private String exerciseName;
        private String question;
        private String answer;
    }
}
