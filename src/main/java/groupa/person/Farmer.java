package groupa.person;

import groupa.crop.Basket;
import groupa.interfaces.Edible;

public class Farmer extends Person {
    private boolean isRiding;

    public Farmer(String name, String favPhrase, int age) {
        super(name, favPhrase, age);
    }



    public boolean isRiding() {
        return isRiding;
    }

    public void setRiding(boolean riding) {
        isRiding = riding;
    }

    @Override
    public void makeNoise() {
        System.out.println(getFavPhrase());
    }

    @Override
    public void eat() {
        Basket.getInstance().takeTomato(2);
        Basket.getInstance().takeEgg(5);
        Basket.getInstance().takeCorn(1);
        System.out.println(getName() + " has had a full meal ");


    }
}