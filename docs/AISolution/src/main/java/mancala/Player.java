package mancala;

import java.util.ArrayList;


public class Player {
    private String name;
    private Store store;

    public Player() {
        name = "Player";
        store = new Store();
    }

    public Player(String name) {
        this.name = name;
        store = new Store();
    }

    public String getName() {
        return name;
    }

    public Store getStore() {
        return store;
    }

    public int getStoreCount() {
        return store.getTotalStones();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String toString() {
        return name;
    }
}