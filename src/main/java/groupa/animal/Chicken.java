package groupa.animal;

import groupa.crop.Basket;
import groupa.interfaces.Edible;
import groupa.interfaces.NoiseMaker;
import groupa.interfaces.Produce;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//done
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
        System.out.println("Chicken " + getName() + getSound());
    }

    @Override
    public void eat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to feed the chicken?\n1. Tomato\n2. Corn\n3. Egg");
        int option = scanner.nextInt();
        switch (option) {
            case 1 -> System.out.println("Chicken cannot eat tomato!");
            case 2 -> Basket.getInstance().takeCorn();
            case 3 -> System.out.println("Chicken cannot eat egg!");
        }
        scanner.close();
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

    public void collectEgg() {
        Egg eggToAdd = null;
        for (Egg egg: eggs) {
            if (egg != null) {
                eggToAdd = egg;
                Basket.getInstance().addTo(eggToAdd);
                eggs.remove(egg);
                break;
            }

        }
    }
}