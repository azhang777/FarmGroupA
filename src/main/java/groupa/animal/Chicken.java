package groupa.animal;
import groupa.interfaces.Edible;
import groupa.interfaces.Produce
public class Chicken extends Animal implements Produce, Edible {

    private boolean hasBeenFertilized;

    public Chicken(String name, int age, boolean hasBeenFertilized) {
        super(name, age);
        this.hasBeenFertilized = hasBeenFertilized;
    }

    @Override
    public void makeNoise() {
        System.out.println("Chicken clucks");
    }

    @Override
    public void eat(Edible food) {
        if (food instanceof EdibleEgg) {
            System.out.println(getName() + " the Chicken is produces an EdibleEgg.");
        } else {
            System.out.println(getName() + " the Chicken doesn't produce any eggs.");
        }
    }

    @Override
    public Edible yieldProduce() {
        if (!hasBeenFertilized) {
            return new EdibleEgg();
        } else {
            return null;
        }
    }
}
