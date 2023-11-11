package com.lesson.spring.hotel.controller;

import com.lesson.spring.hotel.controller.dto.HotelRequestDto;
import com.lesson.spring.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@RequiredArgsConstructor
@Controller
public class HotelController {

    private final HotelService hotelService;

    @GetMapping("/hotels")
    public void find(@ModelAttribute HotelRequestDto requestDto) {
        hotelService.findAll(requestDto);
    }

    @GetMapping("/hotels/{id}")
    public void findById() {

    }


}
