package com.lesson.spring.thread;

import lombok.Getter;
import lombok.Setter;

public class Main {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread() + " main thread start");

        People people = new People("dong");

        new Thread(() -> {
            people.setName("dongwook1");
//            people = new People("dongwook2"); // 객체 외부에서 가져온 값을 바꿀 수 없음(final)
            System.out.println(Thread.currentThread() + " my thread 1 " + people.getName());
        }).start();

        new Thread(() -> {
//            people.setName("dongwook2");
            System.out.println(Thread.currentThread() + " my thread 2 " + people.getName());
        }).start();


        System.out.println(Thread.currentThread() + " main thread end");
    }

}

@Getter
@Setter
class People {

    public  String name;

    public People(String name) {
        this.name = name;
    }
}



/**
 * Thread[main,5,main] main thread start
 * Thread[main,5,main] main thread end
 * Thread[Thread-0,5,main] my thread
 *
 * Thread[main,5,main] main thread start
 * Thread[main,5,main] my thread
 * Thread[main,5,main] main thread end
 */
