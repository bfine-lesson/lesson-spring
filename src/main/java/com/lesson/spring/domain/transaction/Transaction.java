package com.lesson.spring.domain.transaction;


import com.lesson.spring.domain.member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long stockId;

    private TransactionType type;

    private BigDecimal price;

    private Integer quantity;

    private BigDecimal totalPrice;

    private LocalDateTime transactionTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    public Transaction(Long stockId, TransactionType type, BigDecimal price, Integer quantity, Member member) {
        this(null, stockId, type, price, quantity, price.multiply(BigDecimal.valueOf(quantity)), LocalDateTime.now(), member);
    }

    private Transaction(Long id, Long stockId, TransactionType type, BigDecimal price, Integer quantity, BigDecimal totalPrice, LocalDateTime transactionTime, Member member) {
        this.id = id;
        this.stockId = stockId;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.transactionTime = transactionTime;
        this.member = member;
    }
}
