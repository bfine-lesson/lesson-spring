package com.lesson.spring.javastudy.collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Hotel hotel1 = new Hotel("신라", 10000);
        Hotel hotel2 = new Hotel("삼성", 20000);
        Hotel hotel3 = new Hotel("신라", 30000);
        Hotel hotel4 = new Hotel("삼성", 40000);
        Hotel hotel5 = new Hotel("신라", 50000);

        // java 11 list.of
        List<Hotel> hotels = List.of(hotel1, hotel2, hotel3, hotel4, hotel5);

        // 같은 이름 호텔 가격 합산
        Map<String, Integer> map = new HashMap<>();

        for (Hotel hotel : hotels) {

            if (map.containsKey(hotel.getName())) {
                Integer price = map.get(hotel.getName());
                int sumPrice = price + hotel.getPrice();
                map.put(hotel.getName(), sumPrice);
            } else {
                map.put(hotel.getName(), hotel.getPrice());

                // TODO : 각각 동작
//                map.getOrDefault();
//                map.putIfAbsent();

            }
        }
        System.out.println(map);

    }

    //            if (null.equals("신라")){
//            if ("신라".equals(hotel.getName())){
//                totalPrice += hotel.getPrice();


}
