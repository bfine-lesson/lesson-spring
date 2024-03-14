package com.lesson.spring.javastudy.quiz.list.word;

import com.lesson.spring.javastudy.quiz.list.car.Car;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        Word word = new Word();

//        String[] wordLists = {
//                "banana", "apple", "korea", "newjeans", "oak", "spring", "luxury"
//        };

        // TODO : list
        List<String> wordLists = new ArrayList<>(
                List.of("banana1", "banana2", "apple", "korea", "newjeans", "oak", "spring",
                        "luxury"));

        wordLists.sort(Comparator.comparing(String::length).reversed().thenComparing(String::compareTo));

//        Collections.sort(wordLists, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//
//                if (o1.length() == o2.length()) {
//                    return o1.compareTo(o2);
////                    if (i == 0) {}
////                    return i;
//                }
//
//                if (o1.length() > o2.length()) {
//                    return -1;
//                }
//
//                if (o1.length() < o2.length()) {
//                    return 1;
//                }
//
//                return 0;
//
//            }
//
//        });

        for (String wordList : wordLists) {
            System.out.println(wordList);
        }


    }

}
