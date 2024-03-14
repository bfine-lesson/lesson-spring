package com.lesson.spring.api.professor.response;

import com.lesson.spring.entity.Lesson;
import com.lesson.spring.entity.Professor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfessorResponse {

    private Long id;
    private String name;
// professor dto
    public static ProfessorResponse from(Professor professor) {
//        ProfessorResponse.builder()
        return new ProfessorResponse(professor.getId(), professor.getName());
    }

//    public ProfessorResponse(Long id, String name) {
//        this.id = id;
//        this.name = name;
//    }
}
