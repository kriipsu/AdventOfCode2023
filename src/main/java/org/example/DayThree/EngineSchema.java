package org.example.DayThree;

import org.example.FileReaderByLine;
import java.util.ArrayList;

public class EngineSchema {

    private FileReaderByLine fileReaderByLine;
    private ArrayList<ArrayList<Cell>> engineSchema;
    private ArrayList<Part> partList;
    private int partNumberSum;
    private ArrayList<Cell> gearList;
    private int gearProductSum;

    public EngineSchema() {
        this.fileReaderByLine = new FileReaderByLine("src/main/resources/inputDayThree.txt");
        this.engineSchema = new ArrayList<>();
        this.partList = new ArrayList<>();
        this.gearList = new ArrayList<>();
        this.partNumberSum = 0; //get each part, check if valid and add sum
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
                if(cell.getValue().equals("*")){
                    this.gearList.add(cell);
                }
                col++;
            }
            row++;
            col = 0;
        }
    }

    public void generateParts() {
        for (ArrayList<Cell> tempRow:
             this.engineSchema) {
            ArrayList<Cell> tempLocation = new ArrayList<>();
            for (Cell tempCell:
                 tempRow) {
                if (tempCell.getCellType().equals(CellType.NUMBER)) {
                    tempLocation.add(tempCell);
                } else if (!tempLocation.isEmpty()) {
                    Part newPart = new Part(tempLocation, this);
                    this.partList.add(newPart);
                    tempLocation.clear();
                }
            }
            if (!tempLocation.isEmpty()) {
                Part newPart = new Part(tempLocation, this);
                this.partList.add(newPart);
                tempLocation.clear();
            }
        }
    }

    public void calculateGearProduct() {
        for (Cell gear:
             this.gearList) {
            gear.setAdjacentParts(this);
            if(gear.getAdjacentParts().size() == 2) {
                int tempGearProduct = 1;
                for (Part part:
                     gear.getAdjacentParts()) {
                    tempGearProduct *= Integer.parseInt(part.getPartNumber());
                }
                this.gearProductSum += tempGearProduct;
            }
        }
    }

    public void setPartNumberSum() {
        for (Part part:
             this.partList) {
            if (part.isValidPart()) {
                this.partNumberSum += Integer.parseInt(part.getPartNumber());
            }
        }
    }

    public int getPartNumberSum() {
        return partNumberSum;
    }

    public ArrayList<ArrayList<Cell>> getEngineSchema() {
        return engineSchema;
    }

    public int getGearProductSum() {
        return gearProductSum;
    }
}
