package org.example;

public class GameRoundSet {
    private int red;
    private int maxRed;
    private int green;
    private int maxGreen;
    private int blue;
    private int maxBlue;

    public GameRoundSet(int red, int green, int blue) {
        this.maxRed = 12;
        this.maxGreen = 13;
        this.maxBlue = 14;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public boolean isInLimits() {
        return this.red <= this.maxRed && this.green <= this.maxGreen && this.blue <= this.maxBlue;
    }
}
