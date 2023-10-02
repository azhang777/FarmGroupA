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
    public void eat() {
        System.out.println(" will eat 1 Corn, 2 Tomato, and 5 Egg");
        Basket.getInstance().takeCorn();
        Basket.getInstance().takeTomato();
        Basket.getInstance().takeTomato();
        Basket.getInstance().takeEgg();
        Basket.getInstance().takeEgg();
        Basket.getInstance().takeEgg();
        Basket.getInstance().takeEgg();
        Basket.getInstance().takeEgg();
    }

    @Override
    public void makeNoise() {
        System.out.println(getFavPhrase());
    }

}