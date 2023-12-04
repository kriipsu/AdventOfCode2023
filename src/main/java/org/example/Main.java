package org.example;

import org.example.DayFour.DayFour;
import org.example.DayOne.DayOneDigits;
import org.example.DayThree.EngineSchema;
import org.example.DayTwo.GameDayTwo;

public class Main {
    public static void main(String[] args) {
        System.out.print("Day one solution: ");
        DayOneDigits.DayOneDigits();

        System.out.print("Day two solution: ");
        GameDayTwo GameDayTwo = new GameDayTwo();
        GameDayTwo.loopThroughRounds();
        //System.out.println(GameDayTwo.getSumOfID());
        System.out.println(GameDayTwo.getProductOfCubes());

        System.out.print("Day three solution one: ");
        EngineSchema engineSchema = new EngineSchema();
        engineSchema.generateEngineSchema();
        //engineSchema.printSchema();
        engineSchema.generateParts();
        engineSchema.setPartNumberSum();
        System.out.println(engineSchema.getPartNumberSum());
        System.out.print("Day three solution two: ");
        engineSchema.calculateGearProduct();
        System.out.println(engineSchema.getGearProductSum());

        System.out.print("Day four solution one: ");
        DayFour dayFour = new DayFour();
        dayFour.loopThroughCards();
        dayFour.setTotalScore();
        System.out.println(dayFour.getTotalScore());
        System.out.print("Day four solution two: ");
        dayFour.calculateTotalTickets();
        System.out.println(dayFour.getTicketsMapSumOfValues());
    }
}