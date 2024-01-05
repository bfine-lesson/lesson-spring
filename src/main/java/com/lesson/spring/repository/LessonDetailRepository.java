package com.lesson.spring.repository;

import com.lesson.spring.entity.LessonDetail;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LessonDetailRepository {

    private final EntityManager em;

    public void save(LessonDetail lessonDetails) {
        em.persist(lessonDetails);
    }
}
