package com.lesson.spring.answer.Q2.Field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldService {

    @Autowired
    private FieldController fieldController;
}
