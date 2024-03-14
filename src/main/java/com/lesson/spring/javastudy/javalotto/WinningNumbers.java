package com.lesson.spring.javastudy.javalotto;

import java.util.List;
import lombok.Getter;

// TODO : 1. rank enum(카운트, 보너스카운트 받아서 등수까지 반환) 2. test code 작성
@Getter
public class WinningNumbers {

    // bonus, lotto numbers 받아오쟈
    private final LottoNumbers winningLottoNumbers;
    private final BonusNumber bonusNumber;

    public WinningNumbers(LottoNumbers winningLottoNumbers, BonusNumber bonusNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    // lottoNumbers - 구매한 로또 랜덤 번호
    // matchLottoNumber -> lottoNumbers, winningLottoNumbers 비교해서 등수 확인 해주는 메서드
    public Rank matchLottoNumber(LottoNumbers lottoNumbers) {

        List<LottoNumber> winningLottoNumbers = this.winningLottoNumbers.getLottoNumbers();

        List<LottoNumber> submittedLottoNumber = lottoNumbers.getLottoNumbers();

        int count = 0;
        int bonusCount = 0;
        for (LottoNumber lottoNumber : submittedLottoNumber) {
            boolean check = winningLottoNumbers.contains(lottoNumber);
            if (check) {
                count++;
            }
        }

        if (submittedLottoNumber.contains(bonusNumber)) {
            bonusCount++;
        }

        return Rank.calculateRank(count, bonusCount);
    }




}
