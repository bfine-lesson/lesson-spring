package com.lesson.spring.domain.cafe;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CoffeeOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String menu;

    private Boolean isMaleOrder;

    private Boolean isFemaleOrder;

    private Boolean isKidOrder;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Customer customer;

    @Builder
    public CoffeeOrder(String menu, Boolean isMaleOrder, Boolean isFemaleOrder, Boolean isKidOrder, Customer customer) {
        this.menu = menu;
        this.isMaleOrder = isMaleOrder;
        this.isFemaleOrder = isFemaleOrder;
        this.isKidOrder = isKidOrder;
        this.customer = customer;
    }
}
