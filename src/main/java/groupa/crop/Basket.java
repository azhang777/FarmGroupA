package groupa.crop;

import groupa.interfaces.Edible;

import java.util.ArrayList;

public final class Basket {
    private final static Basket basket = new Basket();
    ArrayList<Edible> edibles;
    private Basket() {
        edibles = new ArrayList<>();
    }

    public void addTo(Crop crop) {
        edibles.add(crop.pick());
    }

//    public void addTo(Egg egg) {
//        edibles.add(egg.)
//    }
    public void takeFrom(Edible edible) {
        edibles.remove(edible);
    }

    public static Basket getInstance() {
        return basket;
    }
}
