package com.lesson.spring.repository;

import com.lesson.spring.entity.Lesson;
import com.lesson.spring.entity.Student;
import com.lesson.spring.entity.StudentLesson;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EnrollmentRepository {

    private final EntityManager em;

    public void save(Lesson lesson, Student findStudent) {
        em.persist(new StudentLesson(findStudent, lesson));
    }
}
