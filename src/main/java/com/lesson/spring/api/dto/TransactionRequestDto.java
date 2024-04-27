package com.lesson.spring.api.dto;

import com.lesson.spring.domain.transaction.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.relational.core.sql.In;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class TransactionRequestDto {

    private final Long memberId;
    private final Long stockId;
    private final Integer quantity;
    private final BigDecimal requestPrice;
    private final String transactionType;

}
