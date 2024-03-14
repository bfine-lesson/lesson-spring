package com.lesson.spring.api.student.response;

import com.lesson.spring.api.professor.response.ProfessorResponse;
import com.lesson.spring.entity.Professor;
import com.lesson.spring.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class StudentResponse {

    private Long id;
    private String name;

    public static StudentResponse from(Student student) {
        return new StudentResponse(student.getId(), student.getName());
    }
}
