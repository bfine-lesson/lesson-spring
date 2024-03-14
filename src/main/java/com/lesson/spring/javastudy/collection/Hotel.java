package com.lesson.spring.javastudy.collection;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Hotel {

    private String name;
    private Integer price;

    public Hotel(String name, Integer price) {
        this.name = name;
        this.price = price;
    }


}
