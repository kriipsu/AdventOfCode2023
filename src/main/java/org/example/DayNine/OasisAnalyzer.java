package org.example.DayNine;

import org.example.FileReaderByLine;
import java.util.ArrayList;
import java.util.Arrays;

public class OasisAnalyzer {
    private FileReaderByLine fileReaderByLine;
    private String[] history;
    private int sum;

    public OasisAnalyzer() {
        this.sum = 0;
        this.fileReaderByLine = new FileReaderByLine("src/main/resources/inputDayNine");
        this.history = new String[fileReaderByLine.getInputList().size()];
        readHistory();
    }

    private void readHistory() {
        for (int i = 0; i < this.fileReaderByLine.getInputList().size(); i++) {
            this.history[i] = this.fileReaderByLine.getInputList().get(i);
        }
    }

    public void analyzeRows() {
        for (int i = 0; i < this.history.length; i++) {
            ArrayList<int[]> tempArrayList = new ArrayList<>();
            tempArrayList.add(Arrays.stream(this.history[i].split(" ")).mapToInt(Integer::parseInt).toArray());
            for (int j = 0; j < tempArrayList.size(); j++) {
                if (!Arrays.stream(tempArrayList.get(j)).allMatch(e -> e == 0)) {
                    int[] tempSubArray = new int[tempArrayList.get(j).length - 1];
                    for (int k = 0; k < tempSubArray.length; k++) {
                        tempSubArray[k] = tempArrayList.get(j)[k+1] - tempArrayList.get(j)[k];
                    }
                    tempArrayList.add(tempSubArray);
                }
            }
            int tempMod = 0;
            for (int j = tempArrayList.size() - 2; j > -1; j--) {
                if (j == tempArrayList.size() - 2) {
                    tempMod = tempArrayList.get(j)[0] - tempArrayList.get(j + 1)[0];
                } else {
                    tempMod = tempArrayList.get(j)[0] - tempMod;
                }
            }
            this.sum += tempMod;
        }
    }

    public int getSum() {
        return sum;
    }
}
