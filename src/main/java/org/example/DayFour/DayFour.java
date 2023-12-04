package org.example.DayFour;

import org.example.FileReaderByLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DayFour {
    private FileReaderByLine fileReaderByLine;
    private ArrayList<String> inputDayFour;
    private ArrayList<ScratchCard> scratchCards;
    private int totalScore;
    private HashMap<Integer, Integer> ticketsMap;
    private int totalTicketsCount;

    public DayFour() {
        this.fileReaderByLine = new FileReaderByLine("src/main/resources/inputDayFour.txt");
        this.inputDayFour = fileReaderByLine.getInputList();
        this.scratchCards = new ArrayList<>();
        this.totalScore = 0;
        this.ticketsMap = new HashMap<>();
        this.totalTicketsCount = 0;
    }

    public void loopThroughCards() {
        for (String inputRow:
             inputDayFour) {
            int tempID = Integer.parseInt(inputRow.substring(5, 8).trim());
            String temp = inputRow.substring(9, 40).trim();
            temp = temp.replaceAll(" ", ",");
            String[] splitTemp = temp.split(",");
            ArrayList<Integer> subIntWinningNumbers = new ArrayList<>();
            for (String subPart:
                 splitTemp) {
                if(!subPart.isEmpty()) {
                    subIntWinningNumbers.add(Integer.parseInt(subPart));
                }
            }
            String tempDrawnNumbers = inputRow.substring(41).trim();
            tempDrawnNumbers = tempDrawnNumbers.replaceAll(" ", ",");
            String[] splitTempDrawn = tempDrawnNumbers.split(",");
            ArrayList<Integer> subIntDrawnNumbers = new ArrayList<>();
            for (String subPart:
                    splitTempDrawn) {
                if(!subPart.isEmpty()) {
                    subIntDrawnNumbers.add(Integer.parseInt(subPart));
                }
            }
            ScratchCard card = new ScratchCard(tempID, subIntWinningNumbers, subIntDrawnNumbers);
            this.scratchCards.add(card);
            this.ticketsMap.put(tempID, 1);
        }
    }

    public void setTotalScore() {
        for (ScratchCard card:
             this.scratchCards) {
            this.totalScore += card.getScore();
        }
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void calculateTotalTickets() {
        for (ScratchCard card:
             this.scratchCards) {
            int ticketWinCount = card.getCountWins();
            if (ticketWinCount > 0) {
                for (int i = 1; i <= ticketWinCount; i++) {
                    int currentID = card.getID();
                    int affectedTicketCount = this.ticketsMap.get(currentID + i);
                    this.ticketsMap.put(currentID + i, affectedTicketCount + this.ticketsMap.get(card.getID()));
                }
            }
        }
    }

    public int getTicketsMapSumOfValues() {
        for (int ticketCount:
             this.ticketsMap.values()) {
            this.totalTicketsCount += ticketCount;
        }
        return this.totalTicketsCount;
    }
}
