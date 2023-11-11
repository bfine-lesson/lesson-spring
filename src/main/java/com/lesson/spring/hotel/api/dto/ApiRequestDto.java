package com.lesson.spring.hotel.api.dto;

import java.time.LocalDate;
import lombok.Getter;

@Getter
public class ApiRequestDto {

    private final String owner;
    private final LocalDate availableDate;

    public ApiRequestDto(String owner, LocalDate availableDate) {
        this.owner = owner;
        this.availableDate = availableDate;
    }
}
