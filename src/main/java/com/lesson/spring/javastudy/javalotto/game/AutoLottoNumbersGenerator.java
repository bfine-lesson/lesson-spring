package com.lesson.spring.javastudy.javalotto.game;

import com.lesson.spring.javastudy.javalotto.LottoNumber;
import com.lesson.spring.javastudy.javalotto.LottoNumbers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class AutoLottoNumbersGenerator implements LottoNumbersGenerator {

    private static final int COUNT = 6;
    private static final int RANGE_START_NUMBER = 1;
    private static final int RANGE_END_NUMBER = 45;

    @Override
    public LottoNumbers generateLottoNumbers() {
        Set<Integer> randomNumbers = RandomNumberUtils.makeUniqueRandomNumbers(COUNT,
                RANGE_START_NUMBER,
                RANGE_END_NUMBER);

        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (int randomNumber : randomNumbers) {
            LottoNumber lottoNumber = new LottoNumber(randomNumber);
            lottoNumbers.add(lottoNumber);
        }

        // 정렬 -> 객체와 객체 비교
//        lottoNumbers.sort(LottoNumber::compareTo);

        Collections.sort(lottoNumbers, new Comparator<LottoNumber>() {
            @Override
            public int compare(LottoNumber o1, LottoNumber o2) {
                // getter 미사용
//                return o1.compareTo(o2);

                // getter 사용
                int number1 = o1.getNumber();
                int number2 = o2.getNumber();
                return Integer.compare(number1, number2);
            }
        });

        return new LottoNumbers(lottoNumbers);
    }


}
