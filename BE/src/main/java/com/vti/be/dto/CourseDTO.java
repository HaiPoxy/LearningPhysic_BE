package com.vti.be.dto;

import com.vti.be.entity.Course;
import com.vti.be.entity.Lesson;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Data
@NoArgsConstructor
public class CourseDTO {
    private Integer id;
    private String courseName;
    private String description;
    private List<LessonDTO> lessons ;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class LessonDTO{
    private Integer id;
    private String chapterName;
    private String lessonName;
    }
}
