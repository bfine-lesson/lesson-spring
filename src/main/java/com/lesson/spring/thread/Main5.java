package com.lesson.spring.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main5 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> submit1 = executorService.submit(() -> addWord("", "hello"));
        final String hello = submit1.get();
        System.out.println(hello + " " + Thread.currentThread());

        Future<String> submit2 = executorService.submit(() -> addWord(hello, "world"));
        final String helloWorld = submit2.get();
        System.out.println(helloWorld + " " + Thread.currentThread());

        Future<String> submit3 = executorService.submit(() -> addWord(helloWorld, "happy"));
        final String helloWorldHappy = submit3.get();
        System.out.println(helloWorldHappy + " " + Thread.currentThread());

        executorService.shutdownNow();
    }

    public static String addWord(String target, String word) {
        System.out.println(word + " 추가 " + Thread.currentThread());
        return target + " " + word;
    }
}


