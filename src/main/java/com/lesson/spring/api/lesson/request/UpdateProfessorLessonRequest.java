package com.lesson.spring.api.lesson.request;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProfessorLessonRequest {

    private String name;
    private List<CreateLessonDetailRequest> lessonDetails = new ArrayList<>();

}
