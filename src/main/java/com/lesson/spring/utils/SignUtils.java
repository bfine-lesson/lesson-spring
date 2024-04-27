package com.lesson.spring.utils;

import com.lesson.spring.domain.transaction.TransactionType;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;

@UtilityClass
public class SignUtils {

    private static final BigDecimal MINUS_ONE = BigDecimal.valueOf(-1);

    public static BigDecimal applySign(TransactionType transactionType, BigDecimal price) {
        if (TransactionType.SELL == transactionType) {
            return price.multiply(MINUS_ONE);
        }
       return price;
    }

    public static Integer applySign(TransactionType transactionType, Integer quantity) {
        if (TransactionType.SELL == transactionType) {
            return quantity * MINUS_ONE.intValue();
        }
        return quantity;
    }

}
