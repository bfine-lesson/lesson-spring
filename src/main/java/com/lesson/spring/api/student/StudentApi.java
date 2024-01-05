package com.lesson.spring.api.student;

import com.lesson.spring.api.student.request.CreateStudentRequest;
import com.lesson.spring.api.student.request.UpdateStudentRequest;
import com.lesson.spring.api.student.response.CreateStudentResponse;
import com.lesson.spring.api.student.response.StudentResponse;
import com.lesson.spring.api.student.response.UpdateStudentResponse;
import com.lesson.spring.service.StudentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/students")
public class StudentApi {

    private final StudentService studentService;

    //1. 학생 등록
    @PostMapping
    public CreateStudentResponse save(@RequestBody CreateStudentRequest request) {
        studentService.save(request);
        return new CreateStudentResponse(request.getName());
    }

    //2. 전체 학생 조회
    @GetMapping()
    public List<StudentResponse> findAll() {
        return studentService.findAll();
    }

    //3. 학생 이름으로 조회
    @GetMapping("/find")
    public List<StudentResponse> findByName(@RequestParam String name) {
        return studentService.findByName(name);
    }

    //4. 학생 정보 수정
    @PutMapping("/{studentId}")
    public UpdateStudentResponse updateStudent(
            @PathVariable Long studentId,
            @RequestBody UpdateStudentRequest request) {

        studentService.update(studentId, request);

        return new UpdateStudentResponse(request.getName());
    }

    //5. 힉셍 자퇴
    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.delete(studentId);
    }
}
