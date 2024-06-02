package com.lesson.spring.javastudy.javalotto;

import lombok.ToString;

// 1 game
@ToString
public class LottoGame {

    private LottoNumbers lottoNumbers;

    private final boolean isAuto;

    public LottoGame(LottoNumbers lottoNumbers, boolean isAuto) {
        this.lottoNumbers = lottoNumbers;
        this.isAuto = isAuto;
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean isAuto() {
        return isAuto;
    }

    public void setLottoNumbers(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }
}
