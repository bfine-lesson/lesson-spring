package com.lesson.spring.javastudy.java2;

import java.util.List;

public class UserMain {

    public static void main(String[] args) {
        Item item1 = new Item("phone15", 5000);
        Item item2 = new Item("phone17", 8000);
        List<Item> items = List.of(item1, item2);

        Address address = new Address("seoul");

        Order order = new Order(items, address);
        System.out.println(order);
        // ---------------
        order.changeAddress("busan");
        System.out.println(order);
    }

}
