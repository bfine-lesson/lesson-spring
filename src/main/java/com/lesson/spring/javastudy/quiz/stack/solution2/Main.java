package com.lesson.spring.javastudy.quiz.stack.solution2;

import java.util.Stack;

//Q1. 문자열을 압축해서 출력하세요 예) BBAAGGCNNNNN ⇒ B2A2G2CN5
public class Main {

    public static void main(String[] args) {

        Stack<String> strings = new Stack<>();

        strings.push("A");
        strings.push("B");
        strings.push("B");
        strings.push("B");
        strings.push("C");
        strings.push("C");
        strings.push("C");

        int count = 1;
        String pop = strings.pop();
        System.out.println(pop);
        // pop -> 비교 -> reverse
        System.out.println(strings);


    }

}


