package com.lesson.spring.javastudy.javalotto;

import com.lesson.spring.javastudy.javalotto.game.LottoWinningNumberGenerator;
import java.util.List;

public class LottoResult {

    // lotto
    private final Lotto lotto;
    public LottoResult(Lotto lotto) {
        this.lotto = lotto;
    }

    public void resultGames() {
        List<LottoGame> lottoGames = lotto.getLottoGames();
        LottoWinningNumberGenerator lottoWinningNumberGenerator = new LottoWinningNumberGenerator();
        WinningNumbers winningNumbers = lottoWinningNumberGenerator.generateLottoNumbers();
        System.out.println("당첨 번호 " + winningNumbers.getWinningLottoNumbers() + "보너스 번호 " + winningNumbers.getBonusNumber());
        LottoCheckUp.matchingNumberCalculate(lottoGames, winningNumbers);
    }


}
