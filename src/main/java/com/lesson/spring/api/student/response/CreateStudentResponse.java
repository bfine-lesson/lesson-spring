package com.lesson.spring.api.student.response;

import lombok.Getter;

@Getter
public class CreateStudentResponse {

    private final String name;

    public CreateStudentResponse(String name) {
        this.name = name;
    }
}
