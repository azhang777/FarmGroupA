package groupa.animal;

import groupa.interfaces.Edible;
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
    public void makeNoise() {
        System.out.println("Horse " + getName() + super.getSound());
    }

    @Override
    public void eat(Edible food) {
        if (food instanceof EarCorn) {
            System.out.println(getName() + " the Horse is eating an EarCorn.");
        } else {
            System.out.println(getName() + " the Horse doesn't want to eat this.");
        }
    }


    @Override
    public void eat(Edible food) {

    }

    @Override
    public void makeNoise(String sound) {

    }
}
