package mancala;

import java.util.ArrayList;

public class Store {
    private int totalStones;
    private Player owner;

    public Store() {
        totalStones = 0;
        owner = null;
    }

    public void addStones(int amount) {
        totalStones += amount;
    }

    public int emptyStore() {
        int stonesInStore = totalStones;
        totalStones = 0;
        return stonesInStore;
    }

    public Player getOwner() {
        return owner;
    }

    public int getTotalStones() {
        return totalStones;
    }

    public void setOwner(Player player) {
        owner = player;
    }
    
    public String toString() {
        return "Store with " + totalStones + " stone(s)";
    }
}