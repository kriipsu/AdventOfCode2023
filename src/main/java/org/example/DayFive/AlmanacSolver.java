package org.example.DayFive;

import org.example.FileReaderByLine;
import java.util.ArrayList;

public class AlmanacSolver {
    private FileReaderByLine fileReaderByLine;
    private ArrayList<String> input;
    private ArrayList<Seed> seedsArray;
    private ArrayList<Integer> listOfMaps;


    public AlmanacSolver() {
        this.fileReaderByLine = new FileReaderByLine("src/main/resources/inputDayFive.txt");
        this.input = fileReaderByLine.getInputList();
    }

    public void generateSeeds() {
        /*
        long[] seeds = longArrayFromString(input.get(0));
        this.seedsArray = new ArrayList<>();
        for (long seed:
             seeds) {
            this.seedsArray.add(new Seed(seed));
        }
         */
        this.seedsArray = new ArrayList<>();
        long[] seeds = longArrayFromString(input.get(0));
        long smallestLocation = seeds[0];
        for (int i = 0; i < seeds.length; i = i + 2) {
            for (long j = seeds[i]; j < seeds[i] + seeds[i+1]; j++) {
                Seed temp = new Seed(j);
                loopThroughMaps(temp);
                if (loopThroughMaps(temp) < smallestLocation) {
                    smallestLocation = loopThroughMaps(temp);

                }
            }
        }
        System.out.println(smallestLocation);
    }

    public long generateSmallestLocation() {
        this.seedsArray = new ArrayList<>();
        long[] seeds = longArrayFromString(input.get(0));
        long location = 35088217;
        long seedFromLocation = 0;
        while(true) {
            if (location % 10000 == 0) {
                System.out.println(location);
            }
            seedFromLocation = reverseLoopThroughMaps(location);
            for (int i = 0; i < seeds.length; i = i + 2) {
                if (seedFromLocation >= seeds[i] && seedFromLocation <= (seeds[i] + seeds[i + 1])) {
                    return location;
                }
            }
            location++;
        }
    }

    public long reverseLoopThroughMaps(long location) {
        boolean isSet = false;
        long tempCoordinate = location;
        for (int i = input.size() - 1; i >= 3; i--) {
            if (input.get(i).isEmpty()) {
                isSet = false;
            } else {
                long[] tempArray = longArrayFromString(input.get(i));
                if (!(tempArray == null)) {
                    if (!isSet && tempCoordinate >= tempArray[0] && tempCoordinate <= tempArray[0] + tempArray[2] - 1) {
                        tempCoordinate = tempCoordinate - (tempArray[0] - tempArray[1]);
                        isSet = true;
                    }
                }
            }
        }
        return tempCoordinate;
    }

    private long[] longArrayFromString(String inputString) {
        inputString = inputString.replaceAll("[^0-9]", " ");
        inputString = inputString.replaceAll(" +", " ").trim();
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

    public void printSeeds() {
        for (Seed seed:
             this.seedsArray) {
            System.out.println(seed.getID());
        }
    }

    public void calculateSeedsParameters() {
        for (Seed seed:
                this.seedsArray) {
            loopThroughMaps(seed);
            }
        long smallest = this.seedsArray.get(0).getLocation();
        for (Seed seed:
                this.seedsArray) {
            if (seed.getLocation() < smallest) {
                smallest = seed.getLocation();
            }
        }
        System.out.println(smallest);
    }

    public long loopThroughMaps(Seed seed) {
        long tempCoordinate = seed.getID();
        int counter = 0;
        boolean isSet = false;
        for (int i = 3; i < input.size(); i++) {
            if (input.get(i).isEmpty()) {
                if (!isSet) {
                    setSeedParameter(counter, tempCoordinate, seed);
                }
                counter++;
                isSet = false;
            } else {
                long[] tempArray = longArrayFromString(input.get(i));
                if (!(tempArray == null)) {
                    Map currentMap = new Map(tempArray[1], tempArray[1] + tempArray[2] - 1, tempArray[0] - tempArray[1]);
                    if (!isSet && tempCoordinate >= currentMap.getStart() && tempCoordinate <= currentMap.getEnd()) {
                        setSeedParameter(counter, tempCoordinate + currentMap.getShiftAmount(), seed);
                        tempCoordinate = tempCoordinate + currentMap.getShiftAmount();
                        isSet = true;
                    }
                }
            }
        }
        if (!isSet) {
            setSeedParameter(counter, tempCoordinate, seed);
        }
        return seed.getLocation();
    }

    private void setSeedParameter(int i, long parameter, Seed seed) {
        switch (i) {
            case 0:
                seed.setSoil(parameter);
                break;
            case 1:
                seed.setFertilizer(parameter);
                break;
            case 2:
                seed.setWater(parameter);
                break;
            case 3:
                seed.setLight(parameter);
                break;
            case 4:
                seed.setTemperature(parameter);
                break;
            case 5:
                seed.setHumidity(parameter);
                break;
            case 6:
                seed.setLocation(parameter);
                break;
        }
    }

}
