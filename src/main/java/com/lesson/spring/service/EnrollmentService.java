package com.lesson.spring.service;

import com.lesson.spring.entity.Lesson;
import com.lesson.spring.entity.Student;
import com.lesson.spring.entity.StudentLesson;
import com.lesson.spring.exception.NotFoundStudentException;
import com.lesson.spring.repository.EnrollmentRepository;
import com.lesson.spring.repository.LessonRepository;
import com.lesson.spring.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final LessonRepository lessonRepository;

    @Transactional
    public void enrollLesson(Long lessonId, Long studentId) {

        //1. 강의 정보 찾기
        Lesson findLesson = lessonRepository.findById(lessonId);

        //2. 없으면 예외
        if (findLesson == null) {
            throw new RuntimeException();
        }

        //1. 학생 정보 찾기
        Student findStudent = studentRepository.findById(studentId);

        //2. 없으면 예외
        if (findStudent == null) {
            throw new NotFoundStudentException();
        }

        enrollmentRepository.save(findLesson, findStudent);



    }
}
