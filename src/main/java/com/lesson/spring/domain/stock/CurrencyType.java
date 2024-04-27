package com.lesson.spring.domain.stock;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CurrencyType {

    DOLLAR("USD")
    ,YEN("JPY")
    ,WON("KRW");

    private final String code;
}
