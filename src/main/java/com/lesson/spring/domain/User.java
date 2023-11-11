package com.lesson.spring.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class User {

    private String id;

    private String name;


}
