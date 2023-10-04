package groupa.animal;

import groupa.interfaces.Eater;
import groupa.interfaces.NoiseMaker;
//done
public abstract class Animal implements Eater, NoiseMaker {
    private String sound;
    private String name;
    private int age;

    /**
    All animals will have sound, name, and age parameters
     */
    public Animal(String sound, String name, int age) {
        this.sound = sound;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public abstract void makeNoise();
    public abstract void eat();

}


