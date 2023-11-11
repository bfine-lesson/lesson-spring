package com.lesson.spring.motel.api.request;

import lombok.Getter;

@Getter
public class MotelCreateRequest {

    private final String name;
    private final long price;

    public MotelCreateRequest(String name, long price) {
        this.name = name;
        this.price = price;
    }
}
