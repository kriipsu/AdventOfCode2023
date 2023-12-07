package org.example;

import org.example.DayFive.AlmanacSolver;
import org.example.DayFour.DayFour;
import org.example.DayOne.DayOneDigits;
import org.example.DaySeven.CamelCard;
import org.example.DaySix.RaceSolver;
import org.example.DayThree.EngineSchema;
import org.example.DayTwo.GameDayTwo;

public class Main {
    public static void main(String[] args) {
        /*
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
         */

        /*
        System.out.print("Day five solution two: ");
        AlmanacSolver almanacSolver = new AlmanacSolver();
        System.out.println(almanacSolver.generateSmallestLocation());
        */
        //almanacSolver.generateSeeds();
        //almanacSolver.printSeeds();
        //almanacSolver.calculateSeedsParameters();

        /*
        System.out.print("Day six solution two: ");
        RaceSolver raceSolver = new RaceSolver();
        raceSolver.getRaceData();
        raceSolver.getRaceWinCount();
        System.out.println(raceSolver.getRecord());
         */

        System.out.print("Day seven solution two: ");
        CamelCard camelCard = new CamelCard();
        camelCard.sortHands();
        camelCard.printScore();
    }
}