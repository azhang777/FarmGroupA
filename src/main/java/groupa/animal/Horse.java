package groupa.animal;

import groupa.crop.Basket;
import groupa.crop.Corn;
import groupa.interfaces.Edible;
import groupa.interfaces.Rideable;

import java.util.Scanner;

public class Horse extends Animal implements Rideable {

    private boolean isGalloping;
    private boolean inUse;

    public Horse(String name, int age) {
        super("Neigh", name, age);
        this.isGalloping = false;
        this.inUse = false;
    }
    public boolean isGalloping() {
        return isGalloping;
    }

    public void setGalloping(boolean isGalloping) {
        this.isGalloping = isGalloping;
    }

    @Override
    public void makeNoise() {
        System.out.println("Horse " + getName() + getSound());
    }

    /*
    working, but the takeFrom is not removing the food bc food is a new object different from the food that
    exists in the basket arrayList.
     */

    @Override
    public void eat() {
        System.out.println(getName() + " will eat 3 Corn");
        for (int i = 0; i < 3; i++) {
            Basket.getInstance().takeCorn();
        }
    }
//    @Override
//    public void eat(Edible food) {
//        if (food instanceof Corn) {
//            Basket.getInstance().takeFrom(food);
//            System.out.println(getName() + " the Horse is eating an EarCorn.");
//        } else {
//            System.out.println(getName() + " the Horse doesn't want to eat this.");
//        }
//    }

    @Override
    public boolean isInUse() {
        return false;
    }

    @Override
    public void setInUse() {

    }
}
