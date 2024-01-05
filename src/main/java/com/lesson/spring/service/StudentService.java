package com.lesson.spring.service;

import com.lesson.spring.api.professor.response.ProfessorResponse;
import com.lesson.spring.api.student.request.CreateStudentRequest;
import com.lesson.spring.api.student.request.UpdateStudentRequest;
import com.lesson.spring.api.student.response.StudentResponse;
import com.lesson.spring.entity.Student;
import com.lesson.spring.exception.NotFoundStudentException;
import com.lesson.spring.repository.StudentRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    @Transactional
    public void save(CreateStudentRequest request) {

        // builder 이름 만들어 줄 수 있음
        Student student = Student.builder()
                .name(request.getName())
                .build();

        studentRepository.save(student);
    }

    public List<StudentResponse> findAll() {
        List<Student> students = studentRepository.findAll();

        return students.stream()
                .map(student -> StudentResponse.from(student))
                .toList();

//        return students.stream().map(student -> StudentResponse.builder().id(student.getId())
//                .name(student.getName()).build()).toList();

    }

    public List<StudentResponse> findByName(String name) {

        List<Student> findStudents = studentRepository.findByName(name);

        if (findStudents.isEmpty()) {
            throw new IllegalArgumentException("해당 학생 이름 없음!");
        }

        return findStudents.stream()
                .map(student -> StudentResponse.from(student))
                .toList();

//        return findStudents.stream().map(student -> StudentResponse.builder()
//                .id(student.getId())
//                .name(student.getName())
//                .build()
//        ).toList();
    }

    @Transactional
    public void update(Long studentId, UpdateStudentRequest request) {
        Student findStudent = studentRepository.findById(studentId);

        if (findStudent == null) {
            throw new NotFoundStudentException();
        }

        findStudent.changeName(request.getName());
//        studentRepository.save(findStudent);
    }

    @Transactional
    public void delete(Long studentId) {
        Student findStudent = studentRepository.findById(studentId);

        if (findStudent == null) {
            throw new NotFoundStudentException();
        }

        studentRepository.delete(findStudent.getId());

    }

    public void findById(Long studenId) {

    }
}
