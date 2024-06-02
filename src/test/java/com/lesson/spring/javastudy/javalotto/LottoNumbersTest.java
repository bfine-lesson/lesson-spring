package com.lesson.spring.javastudy.javalotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    @Test
    void duplicatedNumberCheck() {
        //given
        LottoNumber lottoNumber1 = new LottoNumber(1);
        LottoNumber lottoNumber2 = new LottoNumber(1);
        LottoNumber lottoNumber3 = new LottoNumber(1);
        LottoNumber lottoNumber4 = new LottoNumber(1);
        LottoNumber lottoNumber5 = new LottoNumber(1);
        LottoNumber lottoNumber6 = new LottoNumber(1);

        List<LottoNumber> lottoNumbers = List.of(lottoNumber1, lottoNumber2, lottoNumber3,
                lottoNumber4, lottoNumber5, lottoNumber6);

        //when then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoNumbers(lottoNumbers)).withMessage("중복 번호 금지");
    }


}