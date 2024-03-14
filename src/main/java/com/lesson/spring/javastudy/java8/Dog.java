package com.lesson.spring.javastudy.java8;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Dog {

    private String name;
    private int age;
    private List<Baby> babies;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
        this.babies = new ArrayList<>();
    }

    public void addBaby(String name, int age) {
        Baby baby = new Baby(name, age);
        babies.add(baby);
    }

    @ToString
    @Getter
    static class Baby {
        private String name;
        private int age;


        public Baby(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}

//    public Dog(String name, int age) {
//        this(name, age, new ArrayList<>());
//    }
//
//    public Dog(String name, int age, List<Baby> babies) {
//        this.name = name;
//        this.age = age;
//        this.babies = babies;
//    }


