package com.lesson.spring.javastudy.javalotto;

import lombok.EqualsAndHashCode;
import lombok.ToString;

// 로또 번호
@ToString
@EqualsAndHashCode
public class LottoNumber {
    // 제약 1 ->  1 ~ 45
    // 제약 2 ->  6개
    // 제약 3 ->  중복 x
    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException("번호는 1 ~ 45 사이로 선택해주세요");
        }
    }

    // 값 비교
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.number, other.number);
    }

    //getter
    public int getNumber() {
        return number;
    }
}
