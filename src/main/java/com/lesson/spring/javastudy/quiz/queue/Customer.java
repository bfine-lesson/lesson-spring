package com.lesson.spring.javastudy.quiz.queue;

import lombok.ToString;

@ToString
public class Customer {

    private final int number;

    public Customer(int name) {
        this.number = name;
    }

    public int getNumber() {
        return number;
    }

}
