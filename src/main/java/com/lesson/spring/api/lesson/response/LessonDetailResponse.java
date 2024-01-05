package com.lesson.spring.api.lesson.response;

import com.lesson.spring.entity.LessonDetail;
import com.lesson.spring.entity.Week;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

//@AllArgsConstructor
@Getter
public class LessonDetailResponse {

    private String name;
//    private List<LessonDetailDto> lessonDetails;
//    private String content;

    @Builder
    @Getter
    public static class LessonDetailDto {
        private Week week;
        private String content;
    }

    @Builder
    public LessonDetailResponse(String name) {
        this.name = name;
//        this.lessonDetails = lessonDetails;
    }
}
