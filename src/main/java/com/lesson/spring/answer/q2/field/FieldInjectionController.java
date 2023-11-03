package com.lesson.spring.answer.q2.field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FieldInjectionController {

    @Autowired
    private FieldInjectionService fieldInjectionService;


}
