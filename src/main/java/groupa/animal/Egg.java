package groupa.animal;


import groupa.interfaces.Edible;

public class Egg implements Edible {
    private String color;
    private double weight;

    public Egg(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Egg [color=" + color + ", weight=" + weight + " grams]";
    }

    @Override
    public boolean getIfEdible() {
        return false;
    }
}
