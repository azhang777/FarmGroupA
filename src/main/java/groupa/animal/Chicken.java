package groupa.animal;

import groupa.crop.Basket;
import groupa.interfaces.Edible;
import groupa.interfaces.NoiseMaker;
import groupa.interfaces.Produce;
import java.util.ArrayList;
import java.util.List;


public class Chicken extends Animal implements Produce, Edible, NoiseMaker {

    private boolean hasBeenFertilized;
    //private List<Egg> eggs;
    private final boolean isEdible = true;

    public Chicken(String name, int age, boolean hasBeenFertilized) {
        super("Cluck", name, age);
        this.hasBeenFertilized = hasBeenFertilized;
        //this.eggs = new ArrayList<>();
    }

    @Override
    public boolean getIfEdible() {
        return isEdible;
    }

    @Override
    public Edible yields() {
        if (!hasBeenFertilized) {
            Egg egg = new Egg();
            hasBeenFertilized = true;
            return egg;
        } else {
            System.out.println("No egg laid");
        }
        return null;
    }
    public void collectEgg() {
        if (yields() != null) {
            Basket.getInstance().addTo(yields());
        }
    }

    @Override
    public void makeNoise() {
        System.out.println("Chicken " + getName() + getSound());
    }

    @Override
    public void eat() {
    Basket.getInstance().takeCorn(2);
        this.hasBeenFertilized = false;
    }
}