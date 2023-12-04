package org.example.DayFour;

import java.util.ArrayList;

public class ScratchCard {
    private ArrayList<Integer> winningsNumbers;
    private ArrayList<Integer> numbersDrawn;
    private int score;
    private int countWins;
    private int ID;

    public ScratchCard(int ID, ArrayList<Integer> winningsNumbers, ArrayList<Integer> numbersDrawn) {
        this.ID = ID;
        this.winningsNumbers = winningsNumbers;
        this.numbersDrawn = numbersDrawn;
        this.score = setScore();
    }

    public int setScore() {
        int tempScore = 0;
        for (int number:
             numbersDrawn) {
            if (winningsNumbers.contains(number)) {
                if(tempScore == 0 || tempScore == 1) {
                    tempScore += 1;
                } else {
                    tempScore *= 2;
                }
                countWins++;
            }
        }
        return tempScore;
    }

    public int getScore() {
        return score;
    }

    public int getCountWins() {
        return countWins;
    }

    public int getID() {
        return ID;
    }
}
