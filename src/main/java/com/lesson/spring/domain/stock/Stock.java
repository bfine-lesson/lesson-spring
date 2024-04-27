package com.lesson.spring.domain.stock;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private StockType stockType;

    private String companyName;

    @Enumerated(value = EnumType.STRING)
    private CurrencyType currencyType;

    private BigDecimal currentPrice;

    public double calculateRate(BigDecimal averagePrice) {
        BigDecimal subtract = averagePrice.subtract(this.currentPrice);
        return subtract.divide(currentPrice,1,RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .doubleValue();
    }
}
