package com.lesson.spring.entity;

import static jakarta.persistence.CascadeType.PERSIST;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
// TODO: 교수 조회 -> 과목이 여러개 API
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    private String content;

//    @OneToMany(mappedBy = "lesson")
//    private List<LessonProfessor> lessonProfessors = new ArrayList<>();

    @OneToMany(cascade = {PERSIST}, mappedBy = "lesson")
    private List<LessonDetail> lessonDetails = new ArrayList<>();

    @OneToMany(mappedBy = "lesson")
    private List<StudentLesson> studentLessons = new ArrayList<>();

    @Builder
    public Lesson(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void addLessonDetail(LessonDetail lessonDetail) {
        this.lessonDetails.add(lessonDetail);
        lessonDetail.setLesson(this);
    }
}
