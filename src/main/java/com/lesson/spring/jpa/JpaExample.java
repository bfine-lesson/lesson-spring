//package com.lesson.spring.jpa;
//
//import com.lesson.spring.domain.Lesson;
//import com.lesson.spring.domain.LessonDetail;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.Persistence;
//
//import java.util.List;
//
//public class JpaExample {
//
//    public static void main(String[] args) {
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");
//
//        EntityManager em = emf.createEntityManager();
//
//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
//
//        try {
//            List<Lesson> lessons = em.createQuery("select l from Lesson l", Lesson.class)
//                    .getResultList();
//
//            Lesson lesson = lessons.get(2);
//            List<LessonDetail> lessonDetails = lesson.getLessonDetails();
//            LessonDetail lessonDetail = lessonDetails.get(1);
//            lessonDetails.remove(1);
//            transaction.commit();
//        } catch (Exception e) {
//            transaction.rollback();
//            e.printStackTrace();
//        } finally {
//            em.close();
//            emf.close();
//        }
//
//    }
//}
