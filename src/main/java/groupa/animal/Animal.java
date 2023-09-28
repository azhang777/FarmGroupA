package groupa.animal;

import groupa.interfaces.Eater;
import groupa.interfaces.NoiseMaker

public abstract class Animal implements Eater, NoiseMaker {
    private String sound;
    private String name;

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public Animal(String sound, String name) {
        this.sound = sound;
        this.name = name;
    }

    public abstract void makeNoise();


    @Override
    public void eat(Edible food) {
    }
}


