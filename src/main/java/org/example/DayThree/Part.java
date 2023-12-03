package org.example.DayThree;

import java.util.ArrayList;

public class Part {
    private String partNumber;
    private boolean isValidPart;
    private ArrayList<Cell> location;

    public Part(ArrayList<Cell> location, EngineSchema engineSchema) {
        this.location = location;
        this.setPartNumber();
        this.isValidPart = isPartValid(engineSchema);
        this.setPartToCell();
    }

    private boolean isPartValid(EngineSchema engineSchema) {
        for (Cell cell:
             this.location) {
            if(cell.isNextToSymbol(engineSchema)){
                return true;
            }
        }
        return false;
    }

    private void setPartNumber() {
        String tempNumber = "";
        for (Cell cell:
             this.location) {
            tempNumber = tempNumber.concat(cell.getValue());
        }
        this.partNumber = tempNumber;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public boolean isValidPart() {
        return isValidPart;
    }

    private void setPartToCell() {
        for (Cell cell:
             this.location) {
            cell.setInhabitsPart(this);
        }
    }
}
