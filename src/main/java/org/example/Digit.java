package org.example;

public enum Digit {

    ONE("one", "1"),
    TWO("two", "2"),
    THREE("three", "3"),
    FOUR("four", "4"),
    FIVE("five", "5"),
    SIX("six", "6"),
    SEVEN("seven", "7"),
    EIGHT("eight", "8"),
    NINE("nine", "9");

    public final String wordRepresentation;
    public final String digitRepresentation;

    private Digit(String wordRepresentation, String digitRepresentation) {
        this.wordRepresentation = wordRepresentation;
        this.digitRepresentation = digitRepresentation;
    }
}
