package org.example.DayThree;

import org.example.FileReaderByLine;

import java.util.ArrayList;

public class EngineSchema {

    FileReaderByLine fileReaderByLine;
    private ArrayList<ArrayList<Cell>> engineSchema;

    public EngineSchema() {
        this.fileReaderByLine = new FileReaderByLine("src/main/resources/inputDayThree.txt");
        this.engineSchema = new ArrayList<>();
        generateEngineSchema();
    }

    public void generateEngineSchema() {
        int row = 0;
        int col = 0;
        ArrayList<String> input = this.fileReaderByLine.getInputList();
        for (String extractRow:
             input) {
            this.engineSchema.add(new ArrayList<>());
            String[] tempRow = extractRow.split("");
            for (String value:
                 tempRow) {
                CellType tempType;
                if (value.equals(".")) {
                    tempType = CellType.PERIOD;
                } else if (value.matches("[0-9]")) {
                    tempType = CellType.NUMBER;
                } else {
                    tempType = CellType.SYMBOL;
                }
                Cell cell = new Cell(row, col, tempType, value);
                this.engineSchema.get(row).add(cell);
                col++;
            }
            row++;
        }
    }

    public void printSchema() {
        for (ArrayList<Cell> row:
             this.engineSchema) {
            for (Cell cell:
                 row) {
                System.out.print(cell.getValue());
            }
            System.out.println("");
        }
    }
}
