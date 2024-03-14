package com.lesson.spring.javastudy.javalotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.ToString;

@ToString
public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    private void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("번호는 6개만 선택 가능합니다.");
        }
    }

    private void validateDuplicate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> numbers = new HashSet<>();
        numbers.addAll(lottoNumbers);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("중복 번호 금지");
        }
    }


}
