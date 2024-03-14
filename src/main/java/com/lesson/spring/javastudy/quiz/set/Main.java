package com.lesson.spring.javastudy.quiz.set;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<CoffeeShop> coffeeShops = new HashSet<>();
        coffeeShops.add(new CoffeeShop("커피빈","서울"));
        coffeeShops.add(new CoffeeShop("스타벅스","서울"));
        coffeeShops.add(new CoffeeShop("메가커피","서울"));
        coffeeShops.add(new CoffeeShop("커피빈","서울"));
        coffeeShops.add(new CoffeeShop("스타벅스","서울"));
        coffeeShops.add(new CoffeeShop("메가커피","서울"));
        coffeeShops.add(new CoffeeShop("커피빈","경기"));
        coffeeShops.add(new CoffeeShop("스타벅스","경기"));
        coffeeShops.add(new CoffeeShop("메가커피","경기"));
        coffeeShops.add(new CoffeeShop("메가커피","경기"));

        //?? set은 자동 중복 제거?? -> equalsAndHashCode 사용
        for (CoffeeShop coffeeShop : coffeeShops) {
            System.out.println(coffeeShop);
        }





    }

}
