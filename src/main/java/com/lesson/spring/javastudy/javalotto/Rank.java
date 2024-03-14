package com.lesson.spring.javastudy.javalotto;

import lombok.Getter;

@Getter
public enum Rank {

    FIRST(6, 0, "1등"),
    SECOND(5, 1, "2등"),
    THIRD(5, 0, "3등"),
    FOURTH(4, 0, "4등"),
    FIFTH(3, 0, "5등"),
    NOTHING(2, 0, "꽝");

    private final int count;
    private final int bonusCount;
    private final String description;

    Rank(int count, int bonusCount, String description) {
        this.count = count;
        this.bonusCount = bonusCount;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Rank calculateRank(int count, int bonusCount) {
        if (count == 6) {
            return Rank.FIRST;
        } else if (count == 5 && bonusCount == 1) {
            return Rank.SECOND;
        } else if (count == 5) {
            return Rank.THIRD;
        } else if (count == 4) {
            return Rank.FOURTH;
        } else if (count == 3) {
            return Rank.FIFTH;
        } else {
            return Rank.NOTHING;
        }
    }

}
