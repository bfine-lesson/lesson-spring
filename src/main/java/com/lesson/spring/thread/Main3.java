package com.lesson.spring.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main3 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> callable = () -> {
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("실행 " + Thread.currentThread());
            return "world";
        };

        Future<String> submit = executorService.submit(callable);

        for (int i = 0; i < 6; i++) {
            TimeUnit.MILLISECONDS.sleep(100);
            if(submit.isDone()){
                System.out.println("끝! " + Thread.currentThread());
                break;
            }else {
                System.out.println("처리중.. "  + Thread.currentThread());
            }
        }

        System.out.println(submit.get());

        executorService.shutdownNow();
    }
}
