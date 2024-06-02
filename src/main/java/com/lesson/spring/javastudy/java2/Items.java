package com.lesson.spring.javastudy.java2;

import java.util.List;

public class Items {

    private List<Item> items;

    public Items(List<Item> items) {
        this.items = items;
    }

    public int calculateTotalPrice() {
        int totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }


}
