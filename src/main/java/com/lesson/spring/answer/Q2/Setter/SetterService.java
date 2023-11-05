package com.lesson.spring.answer.Q2.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetterService {

    private SetterController setterController;

    @Autowired
    public void setSetterController(SetterController setterController) {
        this.setterController = setterController;
    }
}
