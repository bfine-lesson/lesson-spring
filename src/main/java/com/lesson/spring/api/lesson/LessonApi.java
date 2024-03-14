package com.lesson.spring.api.lesson;

import com.lesson.spring.api.lesson.request.CreateLessonRequest;
import com.lesson.spring.api.lesson.request.UpdateProfessorLessonRequest;
import com.lesson.spring.api.lesson.response.LessonDetailResponse;
import com.lesson.spring.api.lesson.response.LessonResponse;
import com.lesson.spring.service.LessonService;
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
@RequestMapping("/api/lessons")
public class LessonApi {

    private final LessonService lessonService;

    //1. 교수 강의 등록
    @PostMapping("/{professorId}")
    public LessonResponse saveLesson(
            @PathVariable Long professorId,
            @RequestBody CreateLessonRequest request) {
        lessonService.save(professorId, request);
        return new LessonResponse(request.getName());
    }

    //2. 등록한 강의 수정
    @PutMapping("/{lessonId}")
    public LessonResponse updateLesson(
            @PathVariable Long lessonId,
            @RequestBody UpdateProfessorLessonRequest request) {

        lessonService.updateLesson(lessonId, request);
        return new LessonResponse(request.getName());
    }

    //3. 등록한 강의 삭제
    @DeleteMapping("/{lessonId}")
    public void deleteLesson(@PathVariable Long lessonId) {
        lessonService.deleteLesson(lessonId);
    }

    //4. 수업 전체 조회
    @GetMapping()
    public List<LessonResponse> findAllLessons() {
        return lessonService.findAll();
    }

    //5. 수업 이름으로 검색
    @GetMapping("/lesson") //웬만하면 명사, 쿼리스트링 고려
    public List<LessonResponse> findByName(@RequestParam String name) {
        return lessonService.findByName(name);
    }

    //6. 교수 이름으로 수업 검색 (과목 여러개 나오게)
    @GetMapping("/professor")
    public List<LessonDetailResponse> findLessonByProfessorName(@RequestParam String name) {
        return lessonService.findLessonByProfessorName(name);
    }


}
