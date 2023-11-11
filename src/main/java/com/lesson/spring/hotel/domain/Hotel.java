package com.lesson.spring.hotel.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Hotel {

    private Long id;

    private String name;

    private Rating rate;

    private Long price;

    private String owner;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
