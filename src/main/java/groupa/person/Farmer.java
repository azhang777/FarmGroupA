package groupa.person;

import groupa.crop.Crop;
import groupa.farm.CropRow;
import groupa.interfaces.Botanist;
import groupa.interfaces.Edible;
import groupa.interfaces.Rideable;
import groupa.interfaces.Rider;

public class Farmer extends Person implements Botanist, Rider {
    private boolean isRiding;

    public Farmer(String name, String favPhrase, int age) {
        super(name, favPhrase, age);
    }



    public boolean isRiding() {
        return isRiding;
    }

    public void setRiding(boolean riding) {
        isRiding = riding;
    }

    @Override
    public void eat(Edible food) {

    }

    @Override
    public void makeNoise() {
        System.out.println(getFavPhrase());
    }

    @Override
    public void plant(Crop crop, CropRow cropRow) {

    }

    @Override
    public void mount(Rideable rideable) {

    }

    @Override
    public void dismount(Rideable rideable) {

    }
}