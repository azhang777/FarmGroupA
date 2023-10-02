package groupa.crop;

import groupa.animal.Egg;
import groupa.interfaces.Edible;

import java.util.ArrayList;

//need to add ways to find what items are in the arrayList edibles
public final class Basket {
    private final static Basket basket = new Basket();
    ArrayList<Edible> edibles;
    private Basket() {
        edibles = new ArrayList<>();
    }

    public void addTo(Edible edible) {
        edibles.add(edible);
    }

    public boolean takeCorn() {
        for (Edible item: edibles) {
            if (item instanceof Corn) {
                edibles.remove(item);
                return true;
            }
        }
        return false;
    }

    public boolean takeTomato() {
        for (Edible item: edibles) {
            if (item instanceof Tomato) {
                edibles.remove(item);
                return true;
            }
        }
        return false;
    }

    public boolean takeEgg() {
        for (Edible item: edibles) {
            if (item instanceof Egg) {
                edibles.remove(item);
                return true;
            }
        }
        return false;
    }

    public static Basket getInstance() {
        return basket;
    }
}
