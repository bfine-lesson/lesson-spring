package com.lesson.spring.overseas.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/overseas")
public class OverseasApi {

    @GetMapping("/")
    public String overseas(){
        return "overseas";
    }

}
