package com.lesson.spring.repository;

import com.lesson.spring.entity.Professor;
import jakarta.persistence.EntityManager;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProfessorRepository {

    private final EntityManager em;

    public void save(Professor professor) {
        em.persist(professor);
    }

    public List<Professor> findAll() {
      return em.createQuery("select p from Professor p", Professor.class)
              .getResultList();
    }

    public List<Professor> findByName(String name) {
        return em.createQuery("select p from Professor p where p.name = :name", Professor.class)
                .setParameter("name", name)
                .getResultList();
    }

    public Professor findById(Long professorId) {
        return em.find(Professor.class, professorId);
    }

    public void delete(Long professorId) {
        em.createQuery("delete from Professor p where p.id = :professorId")
                .setParameter("professorId", professorId)
                .executeUpdate();
    }
}
