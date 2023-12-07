package org.example.DaySeven;

import org.example.FileReaderByLine;
import java.util.ArrayList;
import java.util.Comparator;

public class CamelCard {
    private FileReaderByLine fileReaderByLine;
    private ArrayList<String> input;
    private ArrayList<Hand> hands;

    public CamelCard() {
        this.fileReaderByLine = new FileReaderByLine("src/main/resources/inputDaySeven.txt");
        this.input = fileReaderByLine.getInputList();
        this.setHands();
    }

    private void setHands() {
        this.hands = new ArrayList<>();
        for (String inputRow:
             input) {
            String[] tempRow = inputRow.split(" ");
            String[] tempCards = tempRow[0].split("");
            this.hands.add(new Hand(tempCards, Integer.parseInt(tempRow[1])));
        }
    }

    public void printHands() {
        for (Hand hand:
             this.hands) {
            System.out.println(hand);
        }
    }
    public void sortHands() {
        this.hands.sort(Comparator.comparing(Hand::getRank).thenComparing(Hand::getFirstCardValue).thenComparing(Hand::getSecondCardValue)
                .thenComparing(Hand::getThirdCardValue).thenComparing(Hand::getFourthCardValue).thenComparing(Hand::getFifthCardValue));
    }
    public void printScore() {
        int score = 0;
        for (int i = 0; i < hands.size(); i++) {
            score += hands.get(i).getBid() * (i + 1);
        }
        System.out.println(score);
    }
}
