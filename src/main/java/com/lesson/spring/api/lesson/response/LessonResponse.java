package com.lesson.spring.api.lesson.response;

import com.lesson.spring.entity.Lesson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class LessonResponse {

    private String name;

    public static LessonResponse from(Lesson lesson) {
        return new LessonResponse(lesson.getName());
    }
}
