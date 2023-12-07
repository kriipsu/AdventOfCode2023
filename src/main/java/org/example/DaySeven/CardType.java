package org.example.DaySeven;

public enum CardType {

    A("A", 14),
    K("K", 13),
    Q("Q", 12),
    J("J", 1),
    T("T", 10);

    private String card;
    private int value;

    CardType(String card, int value) {
        this.card = card;
        this.value = value;
    }

    public String getCard() {
        return card;
    }

    public int getValue() {
        return value;
    }
}
