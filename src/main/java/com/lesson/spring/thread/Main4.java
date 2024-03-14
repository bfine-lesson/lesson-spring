package com.lesson.spring.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main4 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> callable = ()-> {
            System.out.println("큰일 하는 중.. " + Thread.currentThread());
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("큰일 조금만 기다려줘.. " + Thread.currentThread());
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("큰일 끝." + Thread.currentThread());
            return "world";
        };


        Future<String> submit = executorService.submit(callable);
        TimeUnit.MILLISECONDS.sleep(300);
        System.out.println("작은일 처리1 "+Thread.currentThread());

        TimeUnit.MILLISECONDS.sleep(200);
        System.out.println("작은일 처리2 "+Thread.currentThread());

        TimeUnit.MILLISECONDS.sleep(600);
        System.out.println("작은일 처리3 "+Thread.currentThread());

        String world = submit.get();
        System.out.println("hello " + world);

    }

}
