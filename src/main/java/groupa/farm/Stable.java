package groupa.farm;

import groupa.animal.Horse;

import java.util.ArrayList;

public class Stable {

    private ArrayList<Horse> horses;

    public Stable() {
        this.horses = new ArrayList<>();
    }

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public void addHorse(Horse horse) {
        this.horses.add(horse);
    }
}
