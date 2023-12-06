package org.example.DaySix;

import org.example.FileReaderByLine;

public class RaceSolver {
    private long[] raceTimes;
    private long[] raceDistances;
    private FileReaderByLine fileReaderByLine;
    private String[] inputStringArray;
    private int record;

    public RaceSolver() {
        this.fileReaderByLine = new FileReaderByLine("src/main/resources/inputDaySix.txt");
        this.inputStringArray = this.fileReaderByLine.getInputList().toArray(new String[0]);
    }

    public void getRaceData(){
        this.raceTimes = longArrayFromString(inputStringArray[0]);
        this.raceDistances = longArrayFromString(inputStringArray[1]);
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

    private long[] longArrayFromString(String inputString) {
        inputString = inputString.replaceAll(" +", " ").trim();
        inputString = inputString.replaceAll("[^0-9]", "").trim();
        if (inputString.isEmpty()) {
            return null;
        }
        String[] inputStringArray = inputString.split(" ");
        long[] tempLongArray = new long[inputStringArray.length];
        for (int i = 0; i < inputStringArray.length; i++) {
            tempLongArray[i] = Long.parseLong(inputStringArray[i]);
        }
        return tempLongArray;
    }

    public int getRecord() {
        return record;
    }
}
