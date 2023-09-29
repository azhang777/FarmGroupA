package groupa.animal;

import groupa.interfaces.Ridable;

public class Horse extends Animal implements Ridable {

    public Horse(String name, int age) {
        super("Neigh", name, age);
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
        System.out.println(getName() + " the Horse is being ridden.");
    }

    @Override
    public void dismount() {
        System.out.println(getName() + " the Horse is being dismounted.");
    }
}
