package groupa.animal;

import groupa.crop.Basket;
import groupa.crop.Corn;
import groupa.crop.Tomato;
import groupa.interfaces.Edible;
import groupa.interfaces.NoiseMaker;
import groupa.interfaces.Produce;
import java.util.ArrayList;
import java.util.List;
import groupa.animal.Egg;

public class Chicken extends Animal implements Produce, Edible, NoiseMaker {

    private boolean hasBeenFertilized;
    private List<Egg> eggs;
    private final boolean isEdible = true;

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
        if (food instanceof Corn) {
            Basket basket = Basket.getInstance();
            basket.takeFrom(food);
            System.out.println(getName() + " the Chicken is eating corn.");
            hasBeenFertilized = false;
        } else {
            System.out.println(getName() + " the Chicken didn't eat anything.");
        }
    }

    @Override
    public void yield() {
        if (!hasBeenFertilized) {
            Egg egg = new Egg();
            eggs.add(egg);
            hasBeenFertilized = true;
        } else {
            System.out.println("No egg laid");
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
        return isEdible;
    }

    @Override
    public void makeNoise() {
        System.out.println(super.getSound());

    }
    public Egg collectEgg() {
        Egg eggToAdd = null;
        for (Egg egg: eggs) {
            if (egg != null) {
                eggToAdd = egg;
                eggs.remove(egg);
            }

        }
        return eggToAdd;
    }
}