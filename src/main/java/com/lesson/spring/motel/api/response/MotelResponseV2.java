package com.lesson.spring.motel.api.response;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MotelResponseV2 {

    private final String name;
    private final long price;

}
