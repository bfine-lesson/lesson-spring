package com.lesson.spring.api.enrollment;

import com.lesson.spring.api.enrollment.request.EnrollmentRequest;
import com.lesson.spring.api.enrollment.response.EnrollmentResponse;
import com.lesson.spring.service.EnrollmentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EnrollmentApi {
//TODO Q: 별거는 아닌데 신경 쓰였던 게 뭐였는지 질문

    private final EnrollmentService enrollmentService;

    //1. 수강 신청
    @PostMapping("/lessons/{lessonId}/students/{studentId}")
    public EnrollmentResponse enrollLesson(
            @PathVariable Long lessonId,
            @PathVariable Long studentId) {

        enrollmentService.enrollLesson(lessonId, studentId);

        return new EnrollmentResponse();
    }

    //2. 수강 신청 내역 조회

    //3. 수강 신청 변경

    //4. 수강 신청 삭제

}
