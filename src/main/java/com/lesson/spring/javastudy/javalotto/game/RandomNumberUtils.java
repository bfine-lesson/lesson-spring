package com.lesson.spring.javastudy.javalotto.game;

import java.util.HashSet;
import java.util.Set;

public class RandomNumberUtils {

    //  당첨 랜덤 번호 생성 -> 1.몇 개 받을지 2.범위
    public static Set<Integer> makeUniqueRandomNumbers(int count, int rangeStartNumber, int rangeEndNumber) {

        Set<Integer> randomNumbers = new HashSet<>();

        while (randomNumbers.size() != count) {
            int random = (int) (Math.random() * rangeEndNumber + rangeStartNumber);
            randomNumbers.add(random);
        }

        return randomNumbers;
    }


}
