package org.example.DayThree;

public class Cell {
    private CellType cellType;
    private int x;
    private int y;
    private String value;

    public Cell(int x, int y, CellType cellType, String value) {
        this.x = x;
        this.y = y;
        this.cellType = cellType;
        this.value = value;
    }

    public CellType getCellType() {
        return cellType;
    }

    public String getValue() {
        return value;
    }
}
