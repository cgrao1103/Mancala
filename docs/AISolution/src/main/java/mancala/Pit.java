package mancala;
import java.util.ArrayList;


public class Pit {
    private int stoneCount;

    public Pit() {
        stoneCount = 0;
    }

    public int getStoneCount() {
        return stoneCount;
    }

    // Add stones to the pit
    public void addStones(int count) {
        stoneCount += count;
    }

    // Add a single stone to the pit
    public void addStone() {
        addStones(1);
    }

    // Remove stones from the pit
    public int removeStones() {
        int removedStones = stoneCount;
        stoneCount = 0;
        return removedStones;
    }



    public String toString() {
        return "Pit with " + stoneCount + " stone(s)";
    }
}