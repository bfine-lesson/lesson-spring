package com.lesson.spring.repository;

import com.lesson.spring.api.student.response.StudentResponse;
import com.lesson.spring.entity.Student;
import jakarta.persistence.EntityManager;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class StudentRepository {

    private final EntityManager em;

    public void save(Student student) {
        em.persist(student);
    }

    public List<Student> findAll() {
        return em.createQuery("select s from Student s", Student.class).getResultList();
    }

    public List<Student> findByName(String name) {
        return em.createQuery("select s from Student s where s.name = :name", Student.class)
                .setParameter("name", name)
                .getResultList();
    }

    public Student findById(Long studentId) {
        return em.find(Student.class, studentId);
    }

    public void delete(Long findStudentId) {
        em.createQuery("delete from Student s where s.id = :findStudentId")
                .setParameter("findStudentId", findStudentId)
                .executeUpdate();
    }
}
