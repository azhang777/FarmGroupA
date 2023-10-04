package groupa.animal;

import groupa.crop.Basket;
import groupa.interfaces.Rideable;

public class Horse extends Animal implements Rideable {

    private boolean isGalloping;
    private boolean inUse;

    /**
     * Constructor for Horse. Gives name and age. Sets the isGalloping and inUse variables to false
     */
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
    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }


    @Override
    public boolean isInUse() {
        return inUse;
    }

    /**
     * Horse sound of Neigh
     */
    @Override
    public void makeNoise() {
        System.out.println("Horse " + getName() + getSound());
    }

    /**
     * Horse eats 3 corns from basket
     */
    @Override
    public void eat() {
        Basket.getInstance().takeCorn(3);

    }
}
