package com.lesson.spring.javastudy.abstract1;

public class Main {

    public static void main(String[] args) {
        Weapon bow = new Bow(5);
        bow.attack();
        // 1. 공격시작
        // 2. Bow : 화살을 쏜다. x count 반복
        // 3. 공격종료

        Weapon cane= new Cane(5,"cane22");
        cane.attack();

        Weapon sward = new Sward(5);
        sward.attack();

    }

}
