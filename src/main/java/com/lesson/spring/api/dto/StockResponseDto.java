package com.lesson.spring.api.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class StockResponseDto {

    private final Long stockId;

    private final String companyName;

    private final BigDecimal currentPrice;

    private final BigDecimal averagePrice;

    private final BigDecimal totalPrice;

    private final Integer quantity;

    private final Double rate;

    @Builder
    public StockResponseDto(Long stockId, String companyName, BigDecimal currentPrice, BigDecimal averagePrice, BigDecimal totalPrice, Integer quantity, Double rate) {
        this.stockId = stockId;
        this.companyName = companyName;
        this.currentPrice = currentPrice;
        this.averagePrice = averagePrice;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.rate = rate;
    }
}
