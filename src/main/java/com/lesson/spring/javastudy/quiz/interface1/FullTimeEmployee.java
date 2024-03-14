package com.lesson.spring.javastudy.quiz.interface1;

public class FullTimeEmployee implements Employee {

    private static final long TIME_MONEY = 9000;
    private final WorkedHours workedHours;

    public FullTimeEmployee(int hours) {
        this.workedHours = new WorkedHours(hours);
    }

    @Override
    public long calculateSalary() {
        //WorkedHours workedHours = new WorkedHours(10);
        return workedHours.getWorkedHours() * TIME_MONEY;
    }
}
