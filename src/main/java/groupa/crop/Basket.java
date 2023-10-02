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

    public boolean takeCorn(int count) {
        if (checkIfAvailable(1) < count) {
            System.out.println("Not enough corn. corn count: " + checkIfAvailable(1));
            return false;
        }
        edibles.removeIf(item -> item instanceof Corn);
        return true;
    }

    public boolean takeTomato(int count) {
        if (checkIfAvailable(2) < count) {
            System.out.println("Not enough tomato. tomato count: " + checkIfAvailable(2));
            return false;
        }
        edibles.removeIf(item -> item instanceof Tomato);
        return true;
    }

    public boolean takeEgg(int count) {
        if (checkIfAvailable(3) < count) {
            System.out.println("Not enough egg. egg count: " + checkIfAvailable(3));
            return false;
        }
        edibles.removeIf(item -> item instanceof Tomato);
        return true;
    }

    public int totalAmount() {
        return edibles.size();
    }

    public static Basket getInstance() {
        return basket;
    }

    private int checkIfAvailable(int type) {
        int counter = 0;
        if (type == 1) {
            for (Edible item: edibles) {
                if (item instanceof Corn) {
                    counter++;
                }
            }
        }
        else if (type == 2) {
            for (Edible item: edibles) {
                if (item instanceof Tomato) {
                    counter++;
                }
            }
        }
        else if (type == 3) {
            for (Edible item: edibles) {
                if (item instanceof Egg) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
