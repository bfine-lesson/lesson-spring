package com.lesson.spring.javastudy.quiz.stack.solution1;

//Q1. 문자열을 압축해서 출력하세요 예) BBAAGGCNNNNN ⇒ B2A2G2CN5
public class Main {

    public static void main(String[] args) {
        System.out.println(printWord("BBAAGGCNNNNN"));
        System.out.println(printWord("ABBCCCDDDDF"));
    }

    public static String printWord(String str) {
        String answer = "";

        str += " ";

        int count = 1;

        for (int i = 0; i < str.length() - 1; i++) {

            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                answer += str.charAt(i);

                if (count > 1) {
                    answer += count;
                    count = 1;
                }
            }
        }

        return answer;
    }

}
