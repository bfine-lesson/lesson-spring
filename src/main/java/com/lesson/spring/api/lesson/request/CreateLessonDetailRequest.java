package com.lesson.spring.api.lesson.request;

import com.lesson.spring.entity.Week;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateLessonDetailRequest {

    private Week week;
    private String content;

}
