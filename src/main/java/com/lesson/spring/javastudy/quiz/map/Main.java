package com.lesson.spring.javastudy.quiz.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

//    Q1. 같은 호텔인 경우 각각의 리스트로 변경
//    - Hotel(name = “신라”, price = 10000)
//    - Hotel(name = “롯데”, price = 20000)
//    - Hotel(name = “신라”, price = 25000)
//    - Hotel(name = “롯데”, price = 30000)
//    - Hotel(name = “신라”, price = 25000)

//    예시
//    List[Hotel(name = “신라”, price = 10000), Hotel(name = “신라”, price = 25000), Hotel(name = “신라”, price = 25000)]
//    List[Hotel(name = “롯데”, price = 20000), Hotel(name = “롯데”, price = 30000)]

    public static void main(String[] args) {

        Hotel hotel1 = new Hotel("신라", 10000);
        Hotel hotel2 = new Hotel("롯데", 20000);
        Hotel hotel3 = new Hotel("신라", 25000);
        Hotel hotel4 = new Hotel("롯데", 30000);
        Hotel hotel5 = new Hotel("신라", 25000);
        List<Hotel> hotels = List.of(hotel1, hotel2, hotel3, hotel4, hotel5);

        Map<String, List<Hotel>> hotelMap = new HashMap<>();

//        for (Hotel hotel : hotels) {
//            String hotelName = hotel.getName();
//            List<Hotel> hotelList = hotelMap.computeIfAbsent(hotelName, k -> new ArrayList<>());
//            hotelList.add(hotel);
//        }

        for (Hotel hotel : hotels) {

            String hotelName = hotel.getName();

            List<Hotel> hotelList = hotelMap.get(hotelName);

            if (hotelList == null) {
                hotelList = new ArrayList<>();
                hotelMap.put(hotelName, hotelList);
            }

            hotelList.add(hotel);
        }

        for (List<Hotel> hotelsByName : hotelMap.values()) {
            System.out.println(hotelsByName);
        }

    }
}

