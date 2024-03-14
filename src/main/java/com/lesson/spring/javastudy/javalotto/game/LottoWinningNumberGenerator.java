package com.lesson.spring.javastudy.javalotto.game;

import com.lesson.spring.javastudy.javalotto.BonusNumber;
import com.lesson.spring.javastudy.javalotto.LottoNumber;
import com.lesson.spring.javastudy.javalotto.LottoNumbers;
import com.lesson.spring.javastudy.javalotto.WinningNumbers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// 로또 당첨 번호 생성
public class LottoWinningNumberGenerator {

    private static final int COUNT = 7;
    private static final int RANGE_START_NUMBER = 1;
    private static final int RANGE_END_NUMBER = 45;

    public WinningNumbers generateLottoNumbers() {
        Set<Integer> randomNumbers = RandomNumberUtils.makeUniqueRandomNumbers(COUNT,
                RANGE_START_NUMBER, RANGE_END_NUMBER);

        List<LottoNumber> winningNumbers = new ArrayList<>();

        Iterator<Integer> iterator = randomNumbers.iterator();
        // 1,2,3,4,5,6,7
        BonusNumber bonusNumber = null;
        while (iterator.hasNext()) {

            int randomNumber = iterator.next(); //1

            if (!iterator.hasNext()) {
                bonusNumber = new BonusNumber(randomNumber);
                break;
                // return : 메서드가 끝나는 지점 break : 해당하는 반복문이 끝남
            }

            LottoNumber lottoNumber = new LottoNumber(randomNumber);
            winningNumbers.add(lottoNumber);
        }

        winningNumbers.sort(LottoNumber::compareTo);


        LottoNumbers lottoNumbers = new LottoNumbers(winningNumbers);
        return new WinningNumbers(lottoNumbers, bonusNumber);

        // 타입 확인
//        return new WinningNumbers(winningNumbers, bonusNumber);
    }
}
