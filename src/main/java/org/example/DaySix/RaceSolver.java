package org.example.DaySix;

import org.example.FileReaderByLine;

import java.util.ArrayList;

public class RaceSolver {
    private int[] raceTimes;
    private int[] raceDistances;
    private FileReaderByLine fileReaderByLine;
    private String[] inputStringArray;
    private int record;

    public RaceSolver() {
        this.fileReaderByLine = new FileReaderByLine("src/main/resources/inputDaySix.txt");
        this.inputStringArray = this.fileReaderByLine.getInputList().toArray(new String[0]);
    }

    public void getRaceData(){
        this.raceTimes = intArrayFromString(inputStringArray[0]);
        this.raceDistances = intArrayFromString(inputStringArray[1]);
    }

    public void getRaceWinCount() {
        this.record = 1;
        for (int i = 0; i < raceTimes.length; i++) {
            int counter = 0;
            for (int j = 0; j < raceTimes[i]; j++) {
                if ((raceTimes[i] - j) * j> raceDistances[i]) {
                    counter++;
                }
            }
            if (counter > 0) {
                this.record *= counter;
            }
        }
    }

    private int[] intArrayFromString(String inputString) {
        inputString = inputString.replaceAll("[^0-9]", " ");
        inputString = inputString.replaceAll(" +", " ").trim();
        if (inputString.isEmpty()) {
            return null;
        }
        String[] inputStringArray = inputString.split(" ");
        int[] tempIntArray = new int[inputStringArray.length];
        for (int i = 0; i < inputStringArray.length; i++) {
            tempIntArray[i] = Integer.parseInt(inputStringArray[i]);
        }
        return tempIntArray;
    }

    public int getRecord() {
        return record;
    }
}
