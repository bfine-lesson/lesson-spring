package com.lesson.spring.repository;

import com.lesson.spring.entity.Lesson;
import com.lesson.spring.entity.LessonProfessor;
import com.lesson.spring.entity.Professor;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LessonProfessorRepository {

    private final EntityManager em;

    public void save(Lesson lesson, Professor professor) {
        em.persist(new LessonProfessor(lesson, professor));
    }


    public List<Lesson> findAllLessonsByProfessors(List<Professor> professors) {

        List<Lesson> lessons = new ArrayList<>();

        for (Professor professor : professors) {
            List<LessonProfessor> lessonProfessors = em.createQuery(
                            "select lp from LessonProfessor lp where lp.professor = :professor", LessonProfessor.class)
                    .setParameter("professor", professor)
                    .getResultList();

            for (LessonProfessor lessonProfessor : lessonProfessors) {
                Lesson lesson = lessonProfessor.getLesson();
                lessons.add(lesson);
            }
        }

        return lessons;
    }
}
