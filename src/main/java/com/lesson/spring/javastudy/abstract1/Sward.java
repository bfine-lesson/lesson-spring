package com.lesson.spring.javastudy.abstract1;

public class Sward extends Weapon {

    public Sward(int count) {
        super(5);
    }

    @Override
    protected void print() {
        System.out.println("검을 휘두른다.");
    }
}
