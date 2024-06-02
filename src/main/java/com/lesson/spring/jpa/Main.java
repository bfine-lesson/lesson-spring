package com.lesson.spring.jpa;

import com.lesson.spring.javastudy.quiz.interface1.FullTimeEmployee;
import com.lesson.spring.javastudy.quiz.interface1.PartTimeEmployee;
//import com.lesson.spring.javastudy.quiz.interface1.WorkedHours; -> 빼기, 캡슐화

public class Main {
    public static void main(String[] args) {
        FullTimeEmployee 김철수 = new FullTimeEmployee(10);
        FullTimeEmployee 강민수 = new FullTimeEmployee(10);

        System.out.println("정규직");
        System.out.println(김철수.calculateSalary());



        PartTimeEmployee 김덕배 = new PartTimeEmployee(10);
        System.out.println("알바");
        System.out.println(김덕배.calculateSalary());

    }
}
