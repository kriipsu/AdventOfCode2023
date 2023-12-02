package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.print("Day one solution: ");
        DayOneDigits.DayOneDigits();


        System.out.print("Day two solution: ");
        GameDayTwoPartOne GameDayTwo = new GameDayTwoPartOne();
        GameDayTwo.loopThroughRounds();
        System.out.println(GameDayTwo.getSumOfID());
    }
}