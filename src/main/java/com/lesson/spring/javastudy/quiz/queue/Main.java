package com.lesson.spring.javastudy.quiz.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static Queue<Customer> customer = getCustomers();

    public static void main(String[] args) {

        // 전체 인원 확인
        System.out.println(customer);

        while (!customer.isEmpty()) {

        }

        // 오전
        System.out.println("오전");
        morning(18);

        // 오후
        System.out.println("오후");
        afternoon(5);

        // 저녁
        System.out.println("저녁");
        evening(6);

    }

    private static void morning(int limit) {

        for (int i = 0; i < limit; i++) {
            if (customer.isEmpty()) {
                System.out.println("대기 끝");
            }
            System.out.println(customer.poll());
        }

    }


    private static void afternoon(int limit) {

        for (int i = 0; i < limit; i++) {
            System.out.println(customer.poll());
        }
    }


    private static void evening(int limit) {

        for (int i = 0; i < limit; i++) {
            System.out.println(customer.poll());
        }
    }

    private static Queue<Customer> getCustomers() {
        Queue<Customer> customer = new LinkedList<>();

        for (int i = 0; i < 16; i++) {
            customer.add(new Customer(i + 1));
        }

        return customer;
    }



}
