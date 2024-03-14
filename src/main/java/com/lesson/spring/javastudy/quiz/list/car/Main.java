package com.lesson.spring.javastudy.quiz.list.car;

import java.time.YearMonth;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Car> carList = new LinkedList<>();

        carList.add(new Tesla("모델3", 500, YearMonth.of(2023, 11)));
        carList.add(new BMW("320i", 600, YearMonth.of(2023, 12)));
        carList.add(new Audi("A4", 500, YearMonth.of(2023, 10)));
        carList.add(new Tesla("모델S", 700, YearMonth.of(2023, 9)));
        carList.add(new BMW("X5", 800, YearMonth.of(2023, 11)));
        carList.add(new Audi("Q5", 700, YearMonth.of(2023, 12)));
        carList.add(new Tesla("모델Y", 600, YearMonth.of(2023, 10)));

        carList.sort(Comparator.comparing(Car::getPrice).thenComparing(Car::getDeliverDate));


        // 결과 출력
        for (Car car : carList) {
            System.out.println("이름: " + car.getName() + " 가격: " + car.getPrice() + " 배송일: " + car.getDeliverDate());
        }


    }
}
