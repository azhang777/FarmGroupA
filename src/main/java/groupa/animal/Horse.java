package groupa.animal;

import groupa.crop.Basket;
import groupa.interfaces.Rideable;

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
    public boolean isInUse() {
        return inUse;
    }

    @Override
    public void setInUse() {


    }

    @Override
    public void makeNoise() {
        System.out.println("Horse " + getName() + getSound());
    }

    @Override
    public void eat() {
        Basket.getInstance().takeCorn(3);

    }
}
