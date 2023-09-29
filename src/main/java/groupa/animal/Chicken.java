package groupa.animal;

import groupa.interfaces.Edible;
import groupa.interfaces.NoiseMaker;
import groupa.interfaces.Produce;
import java.util.ArrayList;
import java.util.List;
import groupa.animal.Egg;

public class Chicken extends Animal implements Produce, Edible, NoiseMaker {

    private boolean hasBeenFertilized;
    private List<Egg> eggs;

    public Chicken(String name, int age, boolean hasBeenFertilized) {
        super("Cluck", name, age);
        this.hasBeenFertilized = hasBeenFertilized;
        this.eggs = new ArrayList<>();
    }

    @Override
    public void makeNoise() {
        System.out.println("Chicken " + getName() + super.getSound());
    }

    @Override
    public void eat(Edible food) {
        if (food instanceof Egg) {
            System.out.println(getName() + " the Chicken is producing an EdibleEgg.");
            eggs.add((Egg) food);
        } else {
            System.out.println(getName() + " the Chicken doesn't produce any eggs.");
        }
    }

    @Override
    public Edible yieldProduce() {
        if (!hasBeenFertilized) {
            Egg egg = new Egg();
            eggs.add(egg);
            return egg;
        } else {
            return null;
        }
    }

    public List<Egg> getEggs() {
        return eggs;
    }

    public void setEggs(List<Egg> eggs) {
        this.eggs = eggs;
    }

    @Override
    public boolean getIfEdible() {
        return false;
    }

    @Override
    public void makeNoise(String sound) {

    }
}