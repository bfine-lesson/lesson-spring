package com.lesson.spring.hotel.service.dto;

import com.lesson.spring.hotel.domain.Hotel;
import com.lesson.spring.hotel.domain.Rating;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class HotelServiceResponseDto {

    private String name;

    private Rating rate;

    private Long price;

    private String owner;

    private LocalDate startDate;

    private LocalDate endDate;

    public static HotelServiceResponseDto of(Hotel hotel) {
        return new HotelServiceResponseDto(
                hotel.getName(),
                hotel.getRate(),
                hotel.getPrice(),
                hotel.getOwner(),
                hotel.getStartDate(),
                hotel.getEndDate()
        );
    }
    //branch step2

}
