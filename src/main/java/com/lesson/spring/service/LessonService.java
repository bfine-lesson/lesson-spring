package com.lesson.spring.service;

import com.lesson.spring.api.lesson.request.CreateLessonDetailRequest;
import com.lesson.spring.api.lesson.request.CreateLessonRequest;
import com.lesson.spring.api.lesson.request.UpdateProfessorLessonRequest;
import com.lesson.spring.api.lesson.response.LessonDetailResponse;
import com.lesson.spring.api.lesson.response.LessonResponse;
import com.lesson.spring.entity.Lesson;
import com.lesson.spring.entity.LessonDetail;
import com.lesson.spring.entity.Professor;
import com.lesson.spring.exception.NotFoundProfessorException;
import com.lesson.spring.repository.LessonProfessorRepository;
import com.lesson.spring.repository.LessonRepository;
import com.lesson.spring.repository.ProfessorRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LessonService {

    private final LessonRepository lessonRepository;
    private final ProfessorRepository professorRepository;
    private final LessonProfessorRepository lessonProfessorRepository;

    @Transactional
    public void save(Long professorId, CreateLessonRequest request) {
        Professor findProfessor = professorRepository.findById(professorId);
        //TODO: 예외 발생시키기
        if (findProfessor == null) {
            throw new NotFoundProfessorException();
        }

        // TODO : 주석 남기기(변환, 어렵)
        // 1. request 에서 받은 name 을 빌더 패턴을 이용해서 Lesson 엔티티 넣어줌
        // 아이디는 자동으로 생성
        Lesson lesson = Lesson.builder()
                .name(request.getName())
                .build();

        //2. 반복문을 통해 request.getCreateLessonDetailRequests() 사용해서 content 값을 detailRequest 에 저장해줌
        for (CreateLessonDetailRequest detailRequest : request.getCreateLessonDetailRequests()) {
            //3. 1번과 같이 LessonDetail 에 content 를 넣어줌
            LessonDetail lessonDetail = LessonDetail.builder()
                    .content(detailRequest.getContent())
                    .week(detailRequest.getWeek())
                    // week
                    .build();
            //4. addLessonDetail(연관관계 편의메서드)에 lessonDetail 설정
            lesson.addLessonDetail(lessonDetail);
        }

        lessonRepository.save(lesson);
        lessonProfessorRepository.save(lesson, findProfessor);
    }

    @Transactional
    public void updateLesson(Long lessonId, UpdateProfessorLessonRequest request) {
        Lesson findLesson = lessonRepository.findById(lessonId);
        findLesson.changeName(request.getName());
    }


    @Transactional
    public void deleteLesson(Long lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId);
        lessonRepository.deleteLesson(lesson.getId());
    }

    public List<LessonResponse> findAll() {
        List<Lesson> lessons = lessonRepository.findAll();

        return lessons.stream()
                .map(lesson -> LessonResponse.from(lesson))
                .toList();
    }

    public List<LessonResponse> findByName(String name) {
        List<Lesson> lessons = lessonRepository.findByName(name);

        return lessons.stream().map(
                lesson -> LessonResponse.from(lesson)
        ).toList();
    }

    public List<LessonDetailResponse> findLessonByProfessorName(String name) {
        //1. professorRepository 에서 이름 검색해서 다 가져오기
        List<Professor> findProfessors = professorRepository.findByName(name);

        //2. professorRepository 에서 이름 없으면 예외 발생 null, isEmpty 차이
        if (findProfessors == null || findProfessors.isEmpty()) {
            throw new NotFoundProfessorException();
        }

        List<Lesson> allLessonsByProfessors = lessonProfessorRepository.findAllLessonsByProfessors(
                findProfessors);

        List<LessonDetailResponse> lessonDetailResponses = new ArrayList<>();

        for (Lesson lessonByProfessor : allLessonsByProfessors) {
            LessonDetailResponse lessonDetailResponse = LessonDetailResponse.builder()
                    .name(lessonByProfessor.getName())
                    .build();

            lessonDetailResponses.add(lessonDetailResponse);
        }

        return lessonDetailResponses;

    }
}
