package com.lesson.spring.thread;

import static com.lesson.spring.thread.Main5.addWord;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main6 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String helloWorldHappy = CompletableFuture.supplyAsync(() -> addWord("", "hello"))
                .thenApply(hello -> addWord(hello, "world"))
                .thenApply(helloWorld -> addWord(helloWorld, "happy"))
                .get();

        System.out.println(helloWorldHappy+" "+Thread.currentThread());
    }

}
