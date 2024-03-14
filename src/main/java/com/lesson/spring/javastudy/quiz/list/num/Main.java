package com.lesson.spring.javastudy.quiz.list.num;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Num> numList = new LinkedList<>();
        numList.add(new Num("5", 1));
        numList.add(new Num("8", 1));
        numList.add(new Num("0", 1));
        numList.add(new Num("0", 2));
        numList.add(new Num("1", 2));
        numList.add(new Num("1", 1));
        numList.add(new Num("1", 3));

        numList.sort(new Comparator<>() {
            @Override
            public int compare(Num o1, Num o2) {
                int i = o1.getName().compareTo(o2.getName());
                if (i == 0) {
                    int i1 = o1.getPriority().compareTo(o2.getPriority());
                    return i1;
                }
                return i * -1;
            }
        });

        for (Num num : numList) {
            System.out.println(num);
        }


    }

}
