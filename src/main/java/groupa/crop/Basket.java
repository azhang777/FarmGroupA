package groupa.crop;

import groupa.animal.Egg;
import groupa.interfaces.Edible;

import java.util.ArrayList;
import java.util.Iterator;

public final class Basket {
    private final static Basket basket = new Basket();
    ArrayList<Edible> edibles;

    /**
     * Singleton class that instantiates the Basket with Edible objects of Corn, Tomato, and Egg
     */
    private Basket() {
        edibles = new ArrayList<>();
        for (int i = 0; i < 300; i++) {
            edibles.add(new Corn());
        }
        for (int i = 0; i < 30; i++) {
            edibles.add(new Tomato());
            edibles.add(new Egg());
        }
    }

    /**
     * Add edible object into ArrayList of Edible.
     *
     * @param edible
     */
    public void addTo(Edible edible) {
        edibles.add(edible);
    }

    /**
     * Used when Person and Animal need to eat. We must take away the Corn by the amount that needs to be eaten.
     * Before taking away, check if the amount needed is less than the amount that exists. If this is true, remove
     * the earliest elements of Corn that exist in the ArrayList of Edible.
     *
     * @param count
     */
    public void takeCorn(int count) {
        int cornRemoved = 0;
        Iterator<Edible> iterator = edibles.iterator();
        if (checkIfAvailable(1) < count) {
            System.out.println("Not enough corn. corn count: " + checkIfAvailable(1));
            return;
        }

        while (iterator.hasNext() && cornRemoved < count) {
            Edible item = iterator.next();
            if (item instanceof Corn) {
                iterator.remove();
                cornRemoved++;
            }
        }
    }

    /**
     * Used when Person and Animal need to eat. We must take away the Tomato by the amount that needs to be eaten.
     * Before taking away, check if the amount needed is less than the amount that exists. If this is true, remove
     * the earliest elements of Tomato that exist in the ArrayList of Edible.
     *
     * @param count
     */
    public void takeTomato(int count) {
        int tomatoRemoved = 0;
        Iterator<Edible> iterator = edibles.iterator();

        if (checkIfAvailable(2) < count) {
            System.out.println("Not enough tomato. tomato count: " + checkIfAvailable(2));
            return;
        }

        while (iterator.hasNext() && tomatoRemoved < count) {
            Edible item = iterator.next();
            if (item instanceof Tomato) {
                iterator.remove();
                tomatoRemoved++;
            }
        }

        System.out.println(count + " tomato removed from the basket.");
    }

    /**
     * Used when Person and Animal need to eat. We must take away the Egg by the amount that needs to be eaten.
     * Before taking away, check if the amount needed is less than the amount that exists. If this is true, remove
     * the earliest elements of Egg that exist in the ArrayList of Edible.
     *
     * @param count
     */
    public void takeEgg(int count) {
        int eggRemoved = 0;
        Iterator<Edible> iterator = edibles.iterator();

        if (checkIfAvailable(3) < count) {
            System.out.println("Not enough egg. egg count: " + checkIfAvailable(3));
            return;
        }

        while (iterator.hasNext() && eggRemoved < count) {
            Edible item = iterator.next();
            if (item instanceof Egg) {
                iterator.remove();
                eggRemoved++;
            }
        }

        System.out.println(count + " eggs removed from the basket.");

    }

    /**
     * remove all occurrences of null elements in the ArrayList due to the methods that take away from the Basket.
     * Then return the size of the ArrayList of Edible
     * @return int
     */
    public int totalAmount() {
        edibles.removeIf(i -> i == null);
        return edibles.size();
    }

    /**
     * return cornCount, which is incremented everytime we need an instance of Corn inside the ArrayList of Edible.
     * @return int
     */
    public int getCornAmount() {
        int cornCount = 0;
        for (Edible item : edibles) {
            if (item instanceof Corn) {
                cornCount++;
            }
        }
        return cornCount;
    }

    /**
     * return tomatoCount, which is incremented everytime we need an instance of Tomato inside the ArrayList of Edible.
     * @return int
     */
    public int getTomatoAmount() {
        int tomatoCount = 0;
        for (Edible item : edibles) {
            if (item instanceof Tomato) {
                tomatoCount++;
            }
        }
        return tomatoCount;
    }

    /**
     * return eggCount, which is incremented everytime we need an instance of Egg inside the ArrayList of Edible.
     * @return int
     */
    public int getEggAmount() {
        int eggCount = 0;
        for (Edible item : edibles) {
            if (item instanceof Egg) {
                eggCount++;
            }
        }
        return eggCount;
    }

    /**
     * allows us to retrieve and use the singleton object basket that exists.
     * @return Basket
     */
    public static Basket getInstance() {
        return basket;
    }

    /**
     * Utility function that allows us to specify the type of Edible needed within the ArrayList of Edible.
     * Also checks and returns the amount of Edible type that exists within the ArrayList of Edible.
     * @param type
     * @return int
     */
    private int checkIfAvailable(int type) {
        int counter = 0;
        if (type == 1) {
            for (Edible item : edibles) {
                if (item instanceof Corn) {
                    counter++;
                }
            }
        } else if (type == 2) {
            for (Edible item : edibles) {
                if (item instanceof Tomato) {
                    counter++;
                }
            }
        } else if (type == 3) {
            for (Edible item : edibles) {
                if (item instanceof Egg) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
