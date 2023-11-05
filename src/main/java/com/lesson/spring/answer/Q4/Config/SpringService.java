package com.lesson.spring.answer.Q4.Config;

public class SpringService {

    private final SpringRepository springRepository;

    public SpringService(SpringRepository springRepository) {
        this.springRepository = springRepository;
    }
}
