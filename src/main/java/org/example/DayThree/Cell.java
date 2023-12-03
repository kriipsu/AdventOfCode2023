package org.example.DayThree;

import java.util.ArrayList;

public class Cell {
    private CellType cellType;
    private int x;
    private int y;
    private String value;
    private ArrayList<Part> adjecentParts;
    private Part inhabitsPart;

    public Cell(int x, int y, CellType cellType, String value) {
        this.x = x;
        this.y = y;
        this.cellType = cellType;
        this.value = value;
        this.adjecentParts = new ArrayList<>();
    }

    private boolean isValidPos(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i <= n - 1 && j <= m - 1;
    }

    public boolean isNextToSymbol(EngineSchema engineSchema) {
        ArrayList<ArrayList<Cell>> arr = engineSchema.getEngineSchema();
        // Size of given 2d array
        int n = arr.size();
        int m = arr.get(0).size();

        // Checking for all the possible adjacent positions
        if (isValidPos(this.getX() - 1, this.getY() - 1, n, m)) {
            if(arr.get(this.getX() - 1).get(this.getY() - 1).getCellType().equals(CellType.SYMBOL)) {
                return true;
            }
        }
        if (isValidPos(this.getX() - 1, this.getY(), n, m)) {
            if (arr.get(this.getX() - 1).get(this.getY()).getCellType().equals(CellType.SYMBOL)) {
                return true;
            }
        }
        if (isValidPos(this.getX() - 1, this.getY() + 1, n, m)) {
            if(arr.get(this.getX() - 1).get(this.getY() + 1).getCellType().equals(CellType.SYMBOL)) {
                return true;
            }
        }
        if (isValidPos(this.getX(), this.getY() - 1, n, m)) {
            if(arr.get(this.getX()).get(this.getY() - 1).getCellType().equals(CellType.SYMBOL)) {
                return true;
            }
        }
        if (isValidPos(this.getX(), this.getY() + 1, n, m)) {
            if(arr.get(this.getX()).get(this.getY() + 1).getCellType().equals(CellType.SYMBOL)) {
                return true;
            }
        }
        if (isValidPos(this.getX() + 1, this.getY() - 1, n, m)) {
            if(arr.get(this.getX() + 1).get(this.getY() - 1).getCellType().equals(CellType.SYMBOL)) {
                return true;
            }
        }
        if (isValidPos(this.getX() + 1, this.getY(), n, m)) {
            if(arr.get(this.getX() + 1).get(this.getY()).getCellType().equals(CellType.SYMBOL)) {
                return true;
            }
        }
        if (isValidPos(this.getX() + 1, this.getY() + 1, n, m)) {
            if(arr.get(this.getX() + 1).get(this.getY() + 1).getCellType().equals(CellType.SYMBOL)) {
                return true;
            }
        }

        return false;
    }


    public void setAdjacentParts(EngineSchema engineSchema) {
        ArrayList<ArrayList<Cell>> arr = engineSchema.getEngineSchema();
        // Size of given 2d array
        int n = arr.size();
        int m = arr.get(0).size();

        // Checking for all the possible adjacent positions
        if (isValidPos(this.getX() - 1, this.getY() - 1, n, m)) {
            if(arr.get(this.getX() - 1).get(this.getY() - 1).getCellType().equals(CellType.NUMBER)) {
                if(!this.adjecentParts.contains(arr.get(this.getX() - 1).get(this.getY() - 1).getInhabitsPart())){
                    this.adjecentParts.add(arr.get(this.getX() - 1).get(this.getY() - 1).getInhabitsPart());
                }
            }
        }
        if (isValidPos(this.getX() - 1, this.getY(), n, m)) {
            if (arr.get(this.getX() - 1).get(this.getY()).getCellType().equals(CellType.NUMBER)) {
                if(!this.adjecentParts.contains(arr.get(this.getX() - 1).get(this.getY()).getInhabitsPart())) {
                    this.adjecentParts.add(arr.get(this.getX() - 1).get(this.getY()).getInhabitsPart());
                }
            }
        }
        if (isValidPos(this.getX() - 1, this.getY() + 1, n, m)) {
            if(arr.get(this.getX() - 1).get(this.getY() + 1).getCellType().equals(CellType.NUMBER)) {
                if(!this.adjecentParts.contains(arr.get(this.getX() - 1).get(this.getY() + 1).getInhabitsPart())) {
                    this.adjecentParts.add(arr.get(this.getX() - 1).get(this.getY() + 1).getInhabitsPart());
                }
            }
        }
        if (isValidPos(this.getX(), this.getY() - 1, n, m)) {
            if(arr.get(this.getX()).get(this.getY() - 1).getCellType().equals(CellType.NUMBER)) {
                if(!this.adjecentParts.contains(arr.get(this.getX()).get(this.getY() - 1).getInhabitsPart())){
                    this.adjecentParts.add(arr.get(this.getX()).get(this.getY() - 1).getInhabitsPart());
                }
            }
        }
        if (isValidPos(this.getX(), this.getY() + 1, n, m)) {
            if(arr.get(this.getX()).get(this.getY() + 1).getCellType().equals(CellType.NUMBER)) {
                if(!this.adjecentParts.contains(arr.get(this.getX()).get(this.getY() + 1).getInhabitsPart())) {
                    this.adjecentParts.add(arr.get(this.getX()).get(this.getY() + 1).getInhabitsPart());
                }
            }
        }
        if (isValidPos(this.getX() + 1, this.getY() - 1, n, m)) {
            if(arr.get(this.getX() + 1).get(this.getY() - 1).getCellType().equals(CellType.NUMBER)) {
                if(!this.adjecentParts.contains(arr.get(this.getX() + 1).get(this.getY() - 1).getInhabitsPart())) {
                    this.adjecentParts.add(arr.get(this.getX() + 1).get(this.getY() - 1).getInhabitsPart());
                }
            }
        }
        if (isValidPos(this.getX() + 1, this.getY(), n, m)) {
            if(arr.get(this.getX() + 1).get(this.getY()).getCellType().equals(CellType.NUMBER)) {
                if(!this.adjecentParts.contains(arr.get(this.getX() + 1).get(this.getY()).getInhabitsPart())) {
                    this.adjecentParts.add(arr.get(this.getX() + 1).get(this.getY()).getInhabitsPart());
                }
            }
        }
        if (isValidPos(this.getX() + 1, this.getY() + 1, n, m)) {
            if(arr.get(this.getX() + 1).get(this.getY() + 1).getCellType().equals(CellType.NUMBER)) {
                if(!this.adjecentParts.contains(arr.get(this.getX() + 1).get(this.getY() + 1).getInhabitsPart())) {
                    this.adjecentParts.add(arr.get(this.getX() + 1).get(this.getY() + 1).getInhabitsPart());
                }
            }
        }
    }

    public CellType getCellType() {
        return cellType;
    }

    public String getValue() {
        return value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Part getInhabitsPart() {
        return inhabitsPart;
    }

    public void setInhabitsPart(Part inhabitsPart) {
        this.inhabitsPart = inhabitsPart;
    }

    public ArrayList<Part> getAdjacentParts() {
        return adjecentParts;
    }
}
