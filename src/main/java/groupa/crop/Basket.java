package groupa.crop;

import groupa.animal.Egg;
import groupa.interfaces.Edible;

import java.util.ArrayList;
import java.util.Iterator;

public final class Basket {
    private final static Basket basket = new Basket();
    ArrayList<Edible> edibles;
    private Basket() {
        edibles = new ArrayList<>();
        for (int i = 0; i < 140; i++) {
            edibles.add(new Corn());
        }
        for (int i = 0; i < 30; i++) {
            edibles.add(new Tomato());
            edibles.add(new Egg());
        }
    }

    public void addTo(Edible edible) {
        edibles.add(edible);
    }

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

    public int totalAmount() {
        return edibles.size();
    }

    public int getCornAmount() {
        int cornCount = 0;
        for (Edible item: edibles) {
            if (item instanceof Corn) {
                cornCount++;
            }
        }
        return cornCount;
    }

    public int getTomatoAmount() {
        int tomatoCount = 0;
        for (Edible item: edibles) {
            if (item instanceof Tomato) {
                tomatoCount++;
            }
        }
        return tomatoCount;
    }

    public int getEggAmount() {
        int eggCount = 0;
        for (Edible item: edibles) {
            if (item instanceof Egg) {
                eggCount++;
            }
        }
        return eggCount;
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
