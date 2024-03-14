package com.lesson.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LessonDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private Week week;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lesson lesson;

    @Builder
    public LessonDetail(Long id, Week week, String content) {
        this.id = id;
        this.week = week;
        this.content = content;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
