package com.lesson.spring.hotel.domain;

public enum Rating {

    STAR1("1성"),
    STAR2("2성"),
    STAR3("3성"),
    STAR4("4성"),
    STAR5("5성"),
    ;

    private final String description;

    Rating(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
