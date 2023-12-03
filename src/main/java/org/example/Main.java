package org.example;

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

        System.out.println("Day two solution: ");
        EngineSchema engineSchema = new EngineSchema();
        engineSchema.generateEngineSchema();
        engineSchema.printSchema();
    }
}