package org.example.DayTwo;

import java.util.ArrayList;

public class GameRound {
    private String gameRoundInfo;
    private ArrayList<String> roundSetInfo;
    private int roundId;

    public GameRound(String gameRoundInfo) {
        this.gameRoundInfo = gameRoundInfo;
        this.roundSetInfo = new ArrayList<>();
        this.parseRoundInfo();
    }

    private void parseRoundInfo() {
        String[] tempRoundInfo = this.gameRoundInfo.split(":");
        String[] tempRoundName = tempRoundInfo[0].split(" ");
        this.roundId = Integer.parseInt(tempRoundName[1]);
        String[] tempRoundSets = tempRoundInfo[1].split(";");
        for (String set:
             tempRoundSets) {
            this.roundSetInfo.add(set.trim());
        }
    }

    public boolean isGamePossible() {
        for (String set:
             roundSetInfo) {
            int red = 0;
            int green = 0;
            int blue = 0;
            String[] tempSet = set.split(", ");

            for (String cube:
                 tempSet) {
                String[] tempCube = cube.split(" ");
                switch (tempCube[1]) {
                    case "red":
                        red = Integer.parseInt(tempCube[0]);
                        break;
                    case "green":
                        green = Integer.parseInt(tempCube[0]);
                        break;
                    case "blue":
                        blue = Integer.parseInt(tempCube[0]);
                        break;
                }
                GameRoundSet gameRoundSet = new GameRoundSet(red, green, blue);
                if (!gameRoundSet.isInLimits()) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getRoundId() {
        return roundId;
    }

    public int powerOfCubes() {
        int red = 0;
        int green = 0;
        int blue = 0;

        for (String set:
                roundSetInfo) {
            String[] tempSet = set.split(", ");
            for (String cube:
                    tempSet) {
                String[] tempCube = cube.split(" ");
                switch (tempCube[1]) {
                    case "red":
                        if (Integer.parseInt(tempCube[0]) > red) {
                            red = Integer.parseInt(tempCube[0]);
                        }
                        break;
                    case "green":
                        if (Integer.parseInt(tempCube[0]) > green) {
                            green = Integer.parseInt(tempCube[0]);
                        }
                        break;
                    case "blue":
                        if (Integer.parseInt(tempCube[0]) > blue) {
                            blue = Integer.parseInt(tempCube[0]);
                        }
                        break;
                }
            }
        }
        return red * green * blue;
    }
}
