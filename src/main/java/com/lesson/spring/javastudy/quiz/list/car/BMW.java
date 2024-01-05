package com.lesson.spring.javastudy.quiz.list.car;

import java.time.YearMonth;


public class BMW implements Car {

    private String name;
    private Integer price;
    private YearMonth yearMonth;

    public BMW(String name, Integer price, YearMonth yearMonth) {
        this.name = name;
        this.price = price;
        this.yearMonth = yearMonth;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getPrice() {
        return price;
    }

    @Override
    public YearMonth getDeliverDate() {
        return yearMonth;
    }
}
