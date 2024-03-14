package com.lesson.spring.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class LessonTest {


    @Test
    @DisplayName("수업 이름을 변경한다.")
    void changeName() {
        //given
        Lesson lesson = Lesson.builder()
                .name("핵의학")
                .build();
        //when
        lesson.changeName("물리학");

        //then
        Assertions.assertThat(lesson.getName()).isEqualTo("물리학");
    }

    @Test
    @DisplayName("빌더를 통해 수업 객체를 생성하고 과목명을 확인한다.")
    void builderTest() {
        //given
        Lesson lesson = Lesson.builder()
                .name("핵의학")
                .build();
        //when

        //then
        Assertions.assertThat(lesson.getName()).isEqualTo("핵의학");
    }

}