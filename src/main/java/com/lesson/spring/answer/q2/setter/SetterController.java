package com.lesson.spring.answer.q2.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SetterController {

    private SetterService setterService;

    @Autowired
    public void setSetterService(SetterService setterService) {
        this.setterService = setterService;
    }
}
