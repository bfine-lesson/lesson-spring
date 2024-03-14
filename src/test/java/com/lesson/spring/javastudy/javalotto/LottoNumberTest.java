package com.lesson.spring.javastudy.javalotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Value;

class LottoNumberTest {


    @ParameterizedTest
    @ValueSource(ints = {0, 46, 50})
    @DisplayName("로또 번호가 1 ~ 45 사이가 아니면 에러 발생한다.")
    void numberRangeTest(int number){
        //given

        //when then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoNumber(number)).withMessage("번호는 1 ~ 45 사이로 선택해주세요");
    }

}