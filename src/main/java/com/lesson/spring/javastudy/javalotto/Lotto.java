package com.lesson.spring.javastudy.javalotto;

import java.util.List;
import lombok.ToString;

// 로또 용지
@ToString
public class Lotto {
    // 제약 -> 상수들 클래스 맵핑
    //     -> list 1급객체

    private final List<LottoGame> lottoGames;

    public Lotto(List<LottoGame> lottoGame) {
        this.lottoGames = lottoGame;
    }

    public List<LottoGame> getLottoGames() {
        return lottoGames;
    }


}
