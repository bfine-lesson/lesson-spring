package com.lesson.spring.javastudy.abstract1;

public abstract class Weapon {

    int count;
    String name;

    public Weapon(int count) {
        this.count = count;
    }

    public Weapon(int count, String name) {
        this.count = count;
        this.name = name;
    }

    protected abstract void print();

    public void attack() {
        System.out.println(name + ": 공격시작");
        for (int i = 0; i < count; i++) {
            print();
        }
        System.out.println("공격종료");
    }

}
