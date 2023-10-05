package groupa.farm;

import groupa.animal.Chicken;

import java.util.ArrayList;

public class ChickenCoop {
    private ArrayList<Chicken> chickens;
    public ChickenCoop() {
        this.chickens = new ArrayList<>();
    }


    /**
     *
     * @return ArrayList of Chicken
     */
    public ArrayList<Chicken> getChickens() {
        return chickens;
    }

    /**
     * adds chicken object to ArrayList
     * @param chicken
     */
    public void addChicken(Chicken chicken) {
        this.chickens.add(chicken);
    }
}
