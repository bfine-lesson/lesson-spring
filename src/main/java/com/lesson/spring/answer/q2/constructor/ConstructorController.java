package com.lesson.spring.answer.q2.constructor;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConstructorController {

    private final ConstructorService constructorService;

    // 생성자 주입 방식
    public ConstructorController(ConstructorService constructorService) {
        this.constructorService = constructorService;
    }

    // @RequiredArgsConstructor 롬복 어노테이션으로도 사용가능
}
