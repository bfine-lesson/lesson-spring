package com.lesson.spring.javastudy.quiz.list.num;

import lombok.ToString;

@ToString
public class Num {

    private String name;
    private Integer priority;

    public Num(String name, Integer priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public Integer getPriority() {
        return priority;
    }

    // compare
}
