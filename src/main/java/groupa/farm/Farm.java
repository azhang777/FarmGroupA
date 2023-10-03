package groupa.farm;

import groupa.Day;

import java.util.ArrayList;

public class Farm {
    private ArrayList<Stable> stables;
    private ArrayList<ChickenCoop> chickenCoops;
    private FarmHouse farmHouse;
    private Field field;

    public Farm() {
        this.stables = new ArrayList<>();
        this.chickenCoops = new ArrayList<>();
        this.farmHouse = new FarmHouse();
        this.field = new Field();
    }

    public ArrayList<Stable> getStables() {
        return stables;
    }

    public ArrayList<ChickenCoop> getChickenCoops() {
        return chickenCoops;
    }

    public FarmHouse getFarmHouse() {
        return farmHouse;
    }

    public Field getField() {
        return field;
    }

    public void addStables(Stable stable) {
        this.stables.add(stable);
    }

    public void addChickenCoop(ChickenCoop chickenCoop) {
        this.chickenCoops.add(chickenCoop);
    }

    public void setFarmHouse(FarmHouse farmHouse) {
        this.farmHouse = farmHouse;
    }

    public void setField(Field field) {
        this.field = field;
    }
    // toStrings need to be Overrided for corresponding classes
    public void printFarm() {
        System.out.println(stables);
        System.out.println(chickenCoops);
        System.out.println(farmHouse);
    }

    // will work on soon
    public void advanceDay() {
        Day.nextDay();
    }

}
