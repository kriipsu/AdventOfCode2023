package org.example.DayTwo;

import org.example.FileReaderByLine;

import java.util.List;

public class GameDayTwo {
    private FileReaderByLine fileReaderByLine;
    private List<String> listOfInput;
    private int sumOfID;
    private int productOfCubes;

    public GameDayTwo() {
        this.fileReaderByLine = new FileReaderByLine("src/main/resources/inputDayTwo.txt");;
        this.listOfInput = fileReaderByLine.getInputList();
        this.sumOfID = 0;
        this.productOfCubes = 0;
    }

    public void loopThroughRounds() {
        for (String gameRoundInfo:
             listOfInput) {
            GameRound gameRound = new GameRound(gameRoundInfo);
            if(gameRound.isGamePossible()) {
                this.sumOfID += gameRound.getRoundId();
            }
            this.productOfCubes += gameRound.powerOfCubes();
        }
    }

    public int getSumOfID() {
        return sumOfID;
    }

    public int getProductOfCubes() {
        return productOfCubes;
    }
}
