package groupa.farm;

import groupa.animal.Chicken;

import java.util.ArrayList;

public class ChickenCoop {
    private ArrayList<Chicken> chickens;
    public ChickenCoop() {
        this.chickens = new ArrayList<>();
    }


    public ArrayList<Chicken> getChickens() {
        return chickens;
    }

    public void addChicken(Chicken chicken) {
        this.chickens.add(chicken);
    }
}
