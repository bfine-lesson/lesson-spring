package com.lesson.spring.javastudy.javalotto;

import com.lesson.spring.javastudy.javalotto.game.AutoLottoNumbersGenerator;
import com.lesson.spring.javastudy.javalotto.game.LottoNumbersGenerator;
import lombok.Getter;

@Getter
public class LottoShop {

    private final Lotto lotto;

    public LottoShop(Lotto lotto) {
        this.lotto = lotto;
    }

    public Lotto getMakeLotto() {
        for (LottoGame lottoGame : lotto.getLottoGames()) {

            if (lottoGame.isAuto()) {
                LottoNumbersGenerator autoLottoNumbersGenerator = new AutoLottoNumbersGenerator();
                LottoNumbers lottoNumbers = autoLottoNumbersGenerator.generateLottoNumbers();
                lottoGame.setLottoNumbers(lottoNumbers);
            }
        }

        return lotto;
    }



}
