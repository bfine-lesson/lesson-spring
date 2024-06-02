package com.lesson.spring.javastudy.java2;

import java.util.List;
import lombok.ToString;

@ToString
public class Order {

    //private List<Item> items; // 한번더 감싸주기
    private Items items;
    private final Address address;
//    private int totalPrice;
    public Order(List<Item> items, Address address) {
        this.items = new Items(items);
        this.address = address;
//        this.totalPrice = this.items.calculateTotalPrice(); // 굳이 생성자 로직 필욥없음 -> 메서드로 빼쟈 !
    }
    public void changeAddress(String address) {
        this.address.changeAddress(address);
    }

    public int calculateTotalPrice() {
        return this.items.calculateTotalPrice();
    }
}

