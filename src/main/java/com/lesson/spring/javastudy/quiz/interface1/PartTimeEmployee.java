package com.lesson.spring.javastudy.quiz.interface1;

public class PartTimeEmployee implements Employee{

    private static final long TIME_MONEY = 7000;
    private WorkedHours workedHours;

    public PartTimeEmployee(int hours) {
        this.workedHours = new WorkedHours(hours);
    }

    @Override
    public long calculateSalary() {
        //WorkedHours workedHours = new WorkedHours(10);
        return workedHours.getWorkedHours() * TIME_MONEY;
    }
}
