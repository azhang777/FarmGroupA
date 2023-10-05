package groupa.farm;

import groupa.animal.Horse;

import java.util.ArrayList;

public class Stable {

    private ArrayList<Horse> horses;

    public Stable() {
        this.horses = new ArrayList<>();
    }

    /**
     *
     * @return ArrayList of Horse
     */
    public ArrayList<Horse> getHorses() {
        return horses;
    }

    /**
     * Adds horse object to ArrayList
     * @param horse
     */
    public void addHorse(Horse horse) {
        this.horses.add(horse);
    }
}
