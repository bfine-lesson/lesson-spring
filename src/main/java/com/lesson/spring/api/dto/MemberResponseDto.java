package com.lesson.spring.api.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class MemberResponseDto {

    private final Long id;

    private final String name;

    private final List<StockResponseDto> stocks;

    public MemberResponseDto(Long id, String name, List<StockResponseDto> stocks) {
        this.id = id;
        this.name = name;
        this.stocks = stocks;
    }
}
