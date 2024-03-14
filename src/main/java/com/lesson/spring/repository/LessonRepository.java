package com.lesson.spring.repository;

import com.lesson.spring.entity.Lesson;
import com.lesson.spring.entity.Professor;
import jakarta.persistence.EntityManager;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LessonRepository {

    private final EntityManager em;

//    public LessonView save(CreateProfessorLessonRequest request) {
//        return em.persist(request);
//    }

    public void save(Lesson lesson) {
        em.persist(lesson);
    }

    public Lesson findById(Long lessonId) {
        return em.find(Lesson.class, lessonId);
    }

    public void deleteLesson(Long lessonId) {
        em.createQuery("delete from Lesson l where l.id = :lessonId")
                .setParameter("lessonId", lessonId)
                .executeUpdate();
    }

    public List<Lesson> findAll() {
        return em.createQuery("select l from Lesson l", Lesson.class).getResultList();
    }

    public List<Lesson> findByName(String name) {
        return em.createQuery("select l from Lesson l where l.name = :name", Lesson.class)
                .setParameter("name", name)
                .getResultList();
    }
}
