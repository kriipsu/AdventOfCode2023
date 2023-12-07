package org.example.DaySeven;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Hand {
    private int rank;
    private String[] cards;
    private int[] cardValues;
    private int bid;
    private HashMap<String, Integer> countOfDuplicates;

    public Hand(String[] cards, int bid) {
        this.cards = cards;
        this.setCardValues();
        this.setRank();
        this.bid = bid;
    }

    private void setCardValues() {
        this.cardValues = new int[this.cards.length];
        for (int i = 0; i < this.cards.length; i++) {
            if (this.cards[i].matches("[0-9]")) {
                this.cardValues[i] = Integer.parseInt(this.cards[i]);
            } else {
                for (CardType cardType:
                     CardType.values()) {
                    if (cardType.getCard().equals(this.cards[i])) {
                        this.cardValues[i] = cardType.getValue();
                    };
                }
            }
        }
    }

    private void setRank() {
        this.countOfDuplicates = new HashMap<>();

        for (String card : this.cards) {
            Integer count = this.countOfDuplicates.get(card);
            if (count == null) {
                this.countOfDuplicates.put(card, 1);
            } else {
                this.countOfDuplicates.put(card, ++count);
            }
        }
        if (countOfDuplicates.containsKey("J")) {
            int countOfJacks = countOfDuplicates.get("J");
            countOfDuplicates.remove("J");
            if (countOfDuplicates.isEmpty()) {
                this.countOfDuplicates.put("A", 0);
            }
            while (countOfJacks > 0) {
                String temp = Collections.max(countOfDuplicates.entrySet(), Map.Entry.comparingByValue()).getKey();
                countOfDuplicates.put(temp, countOfDuplicates.get(temp) + 1);
                countOfJacks--;
            }
        }

        if (this.countOfDuplicates.containsValue(5)) {
            this.rank = 7;
        } else if (this.countOfDuplicates.containsValue(4)) {
            this.rank = 6;
        } else if (this.countOfDuplicates.containsValue(3) && this.countOfDuplicates.containsValue(2)) {
            this.rank = 5;
        } else if (this.countOfDuplicates.containsValue(3)) {
            this.rank = 4;
        } else if (this.hasTwoPairs()) {
            this.rank = 3;
        } else if (this.countOfDuplicates.containsValue(2)) {
            this.rank = 2;
        } else {
            this.rank = 1;
        }
    }

    private boolean hasTwoPairs(){
        int count = 0;
        for (int value:
             this.countOfDuplicates.values()) {
            if (value == 2) {
                count++;
            }
        }
        return count == 2;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "cards=" + Arrays.toString(cards) +
                ", bid=" + bid +
                '}';
    }

    public int getRank() {
        return rank;
    }

    public int[] getCardValues() {
        return cardValues;
    }

    public int getFirstCardValue() {
        return this.cardValues[0];
    }

    public int getSecondCardValue() {
        return this.cardValues[1];
    }

    public int getThirdCardValue() {
        return this.cardValues[2];
    }

    public int getFourthCardValue() {
        return this.cardValues[3];
    }

    public int getFifthCardValue() {
        return this.cardValues[4];
    }

    public int getBid() {
        return bid;
    }
}
