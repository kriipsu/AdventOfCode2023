package org.example.DayFive;

public class Map {
    private long start;
    private long end;
    private long shiftAmount;

    public Map(long start, long end, long shiftAmount) {
        this.start = start;
        this.end = end;
        this.shiftAmount = shiftAmount;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    public long getShiftAmount() {
        return shiftAmount;
    }
}
