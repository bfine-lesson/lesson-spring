package com.lesson.spring.javastudy.javalotto;

import lombok.Getter;

@Getter
public class BonusNumber extends LottoNumber{
// TODO : auto boxing, unboxing
    public BonusNumber(int randomNumber) {
        super(randomNumber);
    }
}
