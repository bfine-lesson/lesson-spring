package com.lesson.spring.javastudy.javalotto;

import com.lesson.spring.javastudy.javalotto.game.LottoWinningNumberGenerator;
import java.util.List;

public class LottoResult {

    // lotto
    private Lotto lotto;
    public LottoResult(Lotto lotto) {
        this.lotto = lotto;
    }

    public void resultGames() {
        List<LottoGame> lottoGames = lotto.getLottoGames();
        LottoWinningNumberGenerator lottoWinningNumberGenerator = new LottoWinningNumberGenerator();
        WinningNumbers winningNumbers = lottoWinningNumberGenerator.generateLottoNumbers();
        LottoCheckUp.matchingNumberCalculate(lottoGames, winningNumbers);

    }


}
