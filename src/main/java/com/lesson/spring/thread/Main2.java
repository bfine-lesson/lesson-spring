package com.lesson.spring.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        Callable<String> callable = () -> {

            Thread.sleep(1000);

            System.out.println(Thread.currentThread() + " my thread ");
            return "hello world";
        };


        FutureTask futureTask = new FutureTask(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println("main thread ");
        System.out.println(Thread.currentThread() + " -- result " + futureTask.get());
    }

}

