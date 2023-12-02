package org.example;

import java.util.ArrayList;
import java.util.List;

public class GameDayTwoPartOne {
    private FileReaderByLine fileReaderByLine;
    private List<String> listOfInput;
    private int sumOfID;

    public GameDayTwoPartOne() {
        this.fileReaderByLine = new FileReaderByLine("src/main/resources/inputDayTwo.txt");;
        this.listOfInput = fileReaderByLine.getInputList();
        this.sumOfID = 0;
    }

    public void loopThroughRounds() {
        for (String gameRoundInfo:
             listOfInput) {
            GameRound gameRound = new GameRound(gameRoundInfo);
            if(gameRound.isGamePossible()) {
                this.sumOfID += gameRound.getRoundId();
            }
        }
    }

    public int getSumOfID() {
        return sumOfID;
    }
}
