package com.vti.be.dto;

import com.vti.be.entity.Lesson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TheoryDTO {
    private Integer theoryId;
    private String theoryName;
    private String videoUrl;
    private String textContent;
    //private Lesson lesson;
    private Integer lessonId;
    private String lessonName;

    public TheoryDTO(Integer theoryId, String theoryName, String videoUrl, String textContent, Integer lessonId, String lessonName) {
        this.theoryId = theoryId;
        this.theoryName = theoryName;
        this.videoUrl = videoUrl;
        this.textContent = textContent;
        this.lessonId = lessonId;
        this.lessonName = lessonName;
    }
}
