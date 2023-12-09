package org.example.DayEight;

import org.example.FileReaderByLine;
import java.util.ArrayList;
import java.util.Arrays;

public class NavigateWasteland {
    private FileReaderByLine fileReaderByLine;
    private String[] instructions;
    private String[] nodeID;

    public NavigateWasteland() {
        this.fileReaderByLine = new FileReaderByLine("src/main/resources/inputDayEight.txt");
        readFile();
    }

    private void readFile() {
        this.instructions = fileReaderByLine.getInputList().get(0).split("");
        this.nodeID = new String[this.fileReaderByLine.getInputList().size() - 2];
        for (int i = 2; i < fileReaderByLine.getInputList().size(); i++) {
            this.nodeID[i-2] = this.setStringIDs(fileReaderByLine.getInputList().get(i));
        }
    }

    public String setStringIDs(String inputRow) {
        return inputRow.substring(0, 3);
    }


    public int followInstructions() {
     String tempLine = this.fileReaderByLine.getInputList().get(Arrays.asList(this.nodeID).indexOf("AAA")+2);
     String tempCurrent = tempLine.substring(0,3);
     String tempLeft = tempLine.substring(7,10);
     String tempRight = tempLine.substring(12,15);
     ArrayList<String> inputList = this.fileReaderByLine.getInputList();
     int steps = 0;
        for (int i = 0; i < this.instructions.length; i++) {
            if (tempCurrent.equals("ZZZ")) {
                return steps;
            }
            if (instructions[i].equals("L")) {
                tempLine = inputList.get(Arrays.asList(nodeID).indexOf(tempLeft)+2);
                tempCurrent = tempLine.substring(0,3);
                tempLeft = tempLine.substring(7,10);
                tempRight = tempLine.substring(12,15);
            } else {
                tempLine = inputList.get(Arrays.asList(nodeID).indexOf(tempRight)+2);
                tempCurrent = tempLine.substring(0,3);
                tempLeft = tempLine.substring(7,10);
                tempRight = tempLine.substring(12,15);
            }
            if (i + 1 == this.instructions.length) {
                i = -1;
            }
            steps++;
        }
        return -1;
    }
}
