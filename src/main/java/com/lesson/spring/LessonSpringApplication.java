package com.lesson.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LessonSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(LessonSpringApplication.class, args);
    }

}
