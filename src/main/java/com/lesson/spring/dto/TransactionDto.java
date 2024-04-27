package com.lesson.spring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@NoArgsConstructor
public class TransactionDto {
    private Long stockId;
    private Integer quantity;
    private BigDecimal totalPrice;

    public TransactionDto(Long stockId, Integer quantity, BigDecimal totalPrice) {
        this.stockId = stockId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public TransactionDto merge(TransactionDto transactionDto) {
        this.quantity += transactionDto.quantity;
        this.totalPrice = totalPrice.add(transactionDto.totalPrice);
        return this;
    }

    public BigDecimal calculateAveragePrice() {
        return totalPrice.divide(
                BigDecimal.valueOf(quantity),
                RoundingMode.HALF_UP
        );
    }
}
