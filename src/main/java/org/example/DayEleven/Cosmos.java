package org.example.DayEleven;

import org.example.FileReaderByLine;

import java.util.ArrayList;

public class Cosmos {

    private ArrayList<String> input;
    private String[][] initialMap;
    private ArrayList<ArrayList<String>> modifiedMap;
    private ArrayList<Integer> emptyColumns;
    private ArrayList<Integer> emptyRows;
    private FileReaderByLine fileReaderByLine;
    private ArrayList<Galaxy> galaxies;
    private ArrayList<Galaxy> originalGalaxies;
    private int sum;
    private long newSum;

    public Cosmos() {
        this.fileReaderByLine = new FileReaderByLine("src/main/resources/inputDayEleven");
        this.input = fileReaderByLine.getInputList();
        this.emptyRows = new ArrayList<>();
        this.emptyColumns = new ArrayList<>();
        setInitialMap();
        //expandMap();
        //findGalaxies();
        //this.sum = 0;
        //setSum();
        this.newSum = 0;
        this.originalGalaxies = new ArrayList<>();
        this.findOriginalGalaxies();
        this.updateGalaxies();
        this.setNewSum();
    }

    public void setInitialMap() {
        this.initialMap = new String[input.size()][input.get(0).length()];
        for (int i = 0; i < input.size(); i++) {
            String inputRow = this.input.get(i);
            if (!inputRow.contains("#")) {
                this.emptyRows.add(i);
            }
            this.initialMap[i] = inputRow.split("");
        }

        for (int i = 0; i < this.initialMap.length; i++) {
            boolean addColumn = true;
            for (int j = 0; j < this.initialMap[i].length; j++) {
                if (this.initialMap[j][i].equals("#")) {
                    addColumn = false;
                }
            }
            if (addColumn) {
                this.emptyColumns.add(i);
            }
        }
    }

    public void expandMap() {
        this.modifiedMap = new ArrayList<>();
        int rowAdjustment = 0;
        for (int i = 0; i < this.initialMap.length; i++) {
            this.modifiedMap.add(new ArrayList<>());
            if (this.emptyRows.contains(i)) {
                this.modifiedMap.add(new ArrayList<>());
                rowAdjustment++;
            }
            for (int j = 0; j < this.initialMap[i].length; j++) {
                if (this.emptyColumns.contains(j)) {
                    this.modifiedMap.get(i+rowAdjustment).add(".");
                }
                this.modifiedMap.get(i+rowAdjustment).add(this.initialMap[i][j]);
            }
        }
    }

    public void findGalaxies() {
        this.galaxies = new ArrayList<>();
        for (int i = 0; i < this.modifiedMap.size(); i++) {
            for (int j = 0; j < this.modifiedMap.get(i).size(); j++) {
                if (this.modifiedMap.get(i).get(j).equals("#")) {
                    this.galaxies.add(new Galaxy(i, j));
                }
            }
        }
    }

    private void setSum() {
        for (int i = 0; i < this.galaxies.size(); i++) {
            for (int j = i+1; j < this.galaxies.size(); j++) {
                System.out.print(i+1);
                System.out.print(" ");
                System.out.print(j+1);
                System.out.print(" ");
                System.out.println(Math.abs(this.galaxies.get(i).getX() - this.galaxies.get(j).getX()) + Math.abs(this.galaxies.get(i).getY() - this.galaxies.get(j).getY()));
                this.sum += Math.abs(this.galaxies.get(i).getX() - this.galaxies.get(j).getX()) + Math.abs(this.galaxies.get(i).getY() - this.galaxies.get(j).getY());
            }
        }
    }

    public void findOriginalGalaxies() {
        this.galaxies = new ArrayList<>();
        for (int i = 0; i < this.initialMap.length; i++) {
            for (int j = 0; j < this.initialMap[i].length; j++) {
                if (this.initialMap[i][j].equals("#")) {
                    this.originalGalaxies.add(new Galaxy(i, j));
                }
            }
        }
    }

    public void updateGalaxies() {
        for (Galaxy galaxy:
             this.originalGalaxies) {
            long tempX = galaxy.getX();
            long tempY = galaxy.getY();

            long countX = this.emptyRows.stream().filter(e -> e < tempX).count();
            long countY = this.emptyColumns.stream().filter(e -> e < tempY).count();

            galaxy.setX(tempX + countX * 999999);
            galaxy.setY(tempY + countY * 999999);
        }
    }

    private void setNewSum() {
        for (int i = 0; i < this.originalGalaxies.size(); i++) {
            for (int j = i+1; j < this.originalGalaxies.size(); j++) {
                this.newSum += Math.abs(this.originalGalaxies.get(i).getX() - this.originalGalaxies.get(j).getX()) + Math.abs(this.originalGalaxies.get(i).getY() - this.originalGalaxies.get(j).getY());
            }
        }
    }

    public int getSum() {
        return sum;
    }

    public long getNewSum() {
        return newSum;
    }
}