package com.lesson.spring.api.lesson.request;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateLessonRequest {

    private String name;
    private List<CreateLessonDetailRequest> createLessonDetailRequests;



}
