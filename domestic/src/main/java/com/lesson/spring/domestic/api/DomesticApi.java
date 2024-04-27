package com.lesson.spring.domestic.api;

import com.lesson.spring.core.domain.Hotel;
import com.lesson.spring.domestic.service.DomesticService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/domestic")
@RequiredArgsConstructor
public class DomesticApi {

    private final DomesticService domesticService;

    @GetMapping("/")
    public Hotel domestitc() {
        return domesticService.hotel();
    }

}
