package com.lesson.spring.javastudy.abstract1;

public class Bow extends Weapon {

    public Bow(int count) {
        super(count);
    }


    @Override
    protected void print() {
        System.out.println("활을 쏜다.");
    }
}
