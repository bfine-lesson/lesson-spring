package com.lesson.spring.javastudy.quiz.list;

public class Main {

    public static void main(String[] args) {

        Word word = new Word();

        for (int i = 0; i < word.wordLists.length; i++) {
            System.out.println(word.wordLists[i]);
        }

    }

}
