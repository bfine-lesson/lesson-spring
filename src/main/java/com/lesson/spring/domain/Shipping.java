package com.lesson.spring.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Shipping {

    private String zipCode;

    private String zipAddr;

    private String message;

}
