package com.lesson.spring.answer.Q2.Constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConstructorService {

    private final ConstructorController constructorController;

    // 생성자가 1개만 존재할 때는 @Autowired 생략 가능
    @Autowired
    public ConstructorService(ConstructorController constructorController) {
        this.constructorController = constructorController;
    }
}
