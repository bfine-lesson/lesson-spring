package com.lesson.spring.javastudy.quiz.interface1;

public class WorkedHours {

    private final long workedHours;

    public WorkedHours(long workedHours) {
        validate(workedHours);
        this.workedHours = workedHours;
    }

    private void validate(long workedHours) {
        if (workedHours < 0) {
            throw new IllegalArgumentException("0이상 입력해주세요");
        }
    }

    public long getWorkedHours() {
        return workedHours;
    }
}
