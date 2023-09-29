package groupa.animal;

import groupa.interfaces.Eater;
import groupa.interfaces.NoiseMaker

public abstract class Animal implements Eater, NoiseMaker {
    private String sound;
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public Animal(String sound, String name, int age) {
        this.sound = sound;
        this.name = name;
        this.age = age;
    }

    public abstract void makeNoise();


    @Override
    public void eat(Edible food) {
    }
}


