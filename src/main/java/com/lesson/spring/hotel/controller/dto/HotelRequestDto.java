package com.lesson.spring.hotel.controller.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class HotelRequestDto {

    private String owner;
    private LocalDate date;

    public HotelRequestDto(String owner, LocalDate date) {
        this.owner = owner;
        this.date = date;
    }
}
