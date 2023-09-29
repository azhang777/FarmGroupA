package groupa.animal;

import groupa.interfaces.Ridable;

public class Horse extends Animal implements Ridable {

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
    public void ride() {
        if (!inUse) {
            inUse = true;
            setGalloping(true);
            System.out.println(getName() + " the Horse is being ridden.");
        } else {
            System.out.println(getName() + " the Horse is already in use.");
        }
    }

    @Override
    public void dismount() {
        if (inUse) {
            inUse = false;
            setGalloping(false);
            System.out.println(getName() + " the Horse is being dismounted.");
        } else {
            System.out.println(getName() + " the Horse is not in use.");
        }
    }
}
