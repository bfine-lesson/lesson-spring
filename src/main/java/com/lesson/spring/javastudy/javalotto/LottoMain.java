package com.lesson.spring.javastudy.javalotto;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        System.out.println("로또 용지를 작성해주세요");

        LottoNumber lottoNumber1 = new LottoNumber(1);
        LottoNumber lottoNumber2 = new LottoNumber(2);
        LottoNumber lottoNumber3 = new LottoNumber(3);
        LottoNumber lottoNumber4 = new LottoNumber(4);
        LottoNumber lottoNumber5 = new LottoNumber(5);
        LottoNumber lottoNumber6 = new LottoNumber(6);

        List<LottoNumber> game = List.of(lottoNumber1, lottoNumber2, lottoNumber3,
                lottoNumber4, lottoNumber5, lottoNumber6);

        LottoNumbers lottoNumbers = new LottoNumbers(game);
        boolean isAuto = true;

        LottoGame lottoGame = new LottoGame(null, true);

        Lotto lotto = new Lotto(List.of(lottoGame));

        System.out.println("로또가게에 제출");
        LottoShop lottoShop = new LottoShop(lotto);
        Lotto lottoPaper = lottoShop.getMakeLotto();
        System.out.println(lottoPaper);

        System.out.println("------------------------------");
        LottoResult lottoResult = new LottoResult(lottoPaper);
        lottoResult.resultGames();
    }

}
