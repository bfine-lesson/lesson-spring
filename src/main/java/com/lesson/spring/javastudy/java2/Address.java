package com.lesson.spring.javastudy.java2;

import lombok.ToString;

@ToString
public class Address {

    private String address;

    public Address(String address) {
        this.address = address;
    }

    public void changeAddress(String address) {
        this.address = address;
    }
}
