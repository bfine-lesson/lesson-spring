package com.lesson.spring.javastudy.abstract1;

public class Cane extends Weapon {

    public Cane(int count, String name) {
        super(count, name);
    }

    @Override
    protected void print() {
        System.out.println("마법을 사용한다.");
    }
}
