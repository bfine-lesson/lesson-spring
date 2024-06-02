package com.lesson.spring.javastudy.javalotto.game;

import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberUtilsTest {

//    @Test
    @RepeatedTest(value = 1000)
    @DisplayName("램덤 번호 생성 확인")
    void makeUniqueRandomNumbers() {
        //given
        int count = 6;
        int rangeStartNumber = 1;
        int rangeEndNumber = 45;

        //when
        Set<Integer> randomNumbers = RandomNumberUtils.makeUniqueRandomNumbers(count,
                rangeStartNumber,
                rangeEndNumber);

        //then
        Assertions.assertThat(randomNumbers).hasSize(6);
        Assertions.assertThat(randomNumbers).usingRecursiveAssertion()
                .allFieldsSatisfy((randomNumber) -> (int) randomNumber >= rangeStartNumber
                        && (int) randomNumber <= rangeEndNumber);

        Assertions.assertThat(randomNumbers).doesNotHaveDuplicates();
    }


}