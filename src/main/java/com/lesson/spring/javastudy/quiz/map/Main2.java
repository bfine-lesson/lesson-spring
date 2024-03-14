package com.lesson.spring.javastudy.quiz.map;

import com.lesson.spring.javastudy.abstract1.Cane;
import com.lesson.spring.javastudy.abstract1.Weapon;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main2 {

//    Q2. name 호텔이름인경우 합산하여 1개의 객체를 만들어주시면 됩니다. 즉 이름별로 하나의 객체만 생성됨
//    - Hotel(name = “신라”, price = 10000)
//    - Hotel(name = “롯데”, price = 20000)
//    - Hotel(name = “신라”, price = 25000)
//    - Hotel(name = “롯데”, price = 30000)
//    - Hotel(name = “신라”, price = 25000)

//    예시
//    List[Hotel(name = “신라”, price = 60000), Hotel(name = “롯데”, price = 50000)]

    public static void main(String[] args) {
        Hotel hotel1 = new Hotel("신라", 10000);
        Hotel hotel2 = new Hotel("롯데", 20000);
        Hotel hotel3 = new Hotel("신라", 25000);
        Hotel hotel4 = new Hotel("롯데", 30000);
        Hotel hotel5 = new Hotel("신라", 25000);

        List<Hotel> hotels = List.of(hotel1, hotel2, hotel3, hotel4, hotel5);
        Map<String, Hotel> hotelMap = new HashMap<>();

        for (Hotel hotel : hotels) {
            // - 1번째
            // 1. hotel1 ("신라", 10000);
            // 2. 이름 가지고있는지 확인
            // 3. else로 이동
            // 4. 맵에 이름, 호텔 객체 저장
            // 5. 현재 맵 -> {key - 신라, value - hotel{name-신라, price-10000}}

            // - 2번째
            // 1. hotel2 ("롯데", 20000);
            // 2. 이름 가지고있는지 확인
            // 3. else로 이동
            // 4. 맵에 이름, 호텔 객체 저장
            // 5. 맵 -> {key - 신라, value - hotel{name-신라, price-10000}}, { key - 롯데, value-hotel{name-롯데, price-2000}}

            // - 3번째
            // 1. hotel3 ("신라", 25000);
            // 2. 이름 가지고있는지 확인(신라)
            // 3. if 이동
            // 4. 맵에서 키에 맞는 value 가져옴
            // 5  currentHotel({hotel{name-신라, price-10000})
            // 6. price - 10000(기존에 있던 금액)
            // 7. totalPrice - 10000(기존에 있던 금액) + hotel3 가격 (25000)
            // 8. hotelMap 에 총가격을 더해줌

            if (hotelMap.containsKey(hotel.getName())) {
                Hotel currentHotel = hotelMap.get(hotel.getName()); //{hotel{name-신라, price-10000})
                currentHotel.merge(hotel);
            } else {
                hotelMap.put(hotel.getName(), hotel);
            }
        }
        System.out.println(hotelMap);
    }



}
