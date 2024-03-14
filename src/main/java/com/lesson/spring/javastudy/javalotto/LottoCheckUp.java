package com.lesson.spring.javastudy.javalotto;

import java.util.List;

public class LottoCheckUp {

    public static void matchingNumberCalculate(List<LottoGame> lottoGames,
            WinningNumbers winningNumbers) {

        for (LottoGame lottoGame : lottoGames) {
            LottoNumbers lottoNumbers = lottoGame.getLottoNumbers();
            Rank rank = winningNumbers.matchLottoNumber(lottoNumbers);
            System.out.println(rank.getDescription());
        }
    }



}
