package groupa.animal;

import groupa.crop.Basket;
import groupa.interfaces.Edible;
import groupa.interfaces.NoiseMaker;
import groupa.interfaces.Produce;



public class Chicken extends Animal implements Produce, Edible, NoiseMaker {

    private boolean hasBeenFertilized;
    private final boolean isEdible = true;

    /**
     * Constructor for Chicken with name, age. and fertilization parameters
     */
    public Chicken(String name, int age, boolean hasBeenFertilized) {
        super("Cluck", name, age);
        this.hasBeenFertilized = hasBeenFertilized;

    }

    /**
     The getIfEdible method in the Chicken class returns a boolean value indicating whether the chicken is edible or not.
     */
    @Override
    public boolean getIfEdible() {
        return isEdible;
    }

    /**
     * yields method determines whether Chicken can produce and egg or not.
     */
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

    /**
     * The collectEgg method in the Chicken class is responsible for collecting an egg from a chicken and adding it to the Basket of edibles.
     */
    public void collectEgg(Edible egg) {
        if (egg != null) {
            Basket.getInstance().addTo(egg);
        }
    }

    /**
     * The makeNoise method in the Chicken class is responsible for printing out the sound of a chicken along with its name.
     */
    @Override
    public void makeNoise() {
        System.out.println("Chicken " + getName() + getSound());
    }

    /**
     * The chicken eats 2 corns from the basket
     */
    @Override
    public void eat() {
    Basket.getInstance().takeCorn(2);
        this.hasBeenFertilized = false;
    }
}