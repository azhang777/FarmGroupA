package groupa.person;

import groupa.animal.Horse;
import groupa.crop.Basket;
import groupa.crop.Crop;
import groupa.crop.Tomato;
import groupa.farm.CropRow;
import groupa.interfaces.*;
import groupa.vehicle.Aircraft;
import groupa.vehicle.CropDuster;
import groupa.vehicle.Tractor;

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
    public void makeNoise() {
        System.out.println(getFavPhrase());
    }

    @Override
    public void eat() {
        System.out.println(getName() + " tries to eat.");
        Basket.getInstance().takeTomato(2);
        Basket.getInstance().takeEgg(5);
        Basket.getInstance().takeCorn(1);
    }
//The plant method in the Farmer class is used to add a Crop object to a CropRow object.
    @Override
    public void plant(Crop crop, CropRow cropRow) {
        cropRow.getCrops().add(crop);
    }

    /*
    The mount method in the Farmer class is used to mount a Rideable object,
     which can be either a FarmVehicle or a Horse. If the Rideable object is a FarmVehicle and specifically a Tractor,
      the method checks if the tractor is not already in use and then sets it to be in use. If the Rideable object is a Horse,
      the method checks if the horse is not already in use and then sets it to be in use. If the Rideable object is neither
       a FarmVehicle nor a Horse, the method does nothing.
     */
    @Override
    public void mount(Rideable rideable) {
        if (rideable instanceof FarmVehicle) {
            if (rideable instanceof Tractor) {
                if (!rideable.isInUse()) {
                    System.out.println(getName() + " is now operating the vehicle under " + ((Tractor) rideable).getId());
                    ((Tractor) rideable).operate(true);

                }

            }
        } else if (rideable instanceof Horse) {
            if (!rideable.isInUse()) {
                (rideable).setInUse(true);

            } else
                System.out.println("Farmer is not able to ride this he is tooo dumb");
        }
    }

    @Override
    public void dismount(Rideable rideable) {
        if (rideable instanceof FarmVehicle) {
            if (rideable instanceof Tractor) {
                if (rideable.isInUse()) {
                    ((Tractor) rideable).operate(false);

                }

            }
        } else if (rideable instanceof Horse) {
            if (rideable.isInUse()) {
                System.out.println(getName() + " is leaving the vehicle under " + ((Tractor) rideable).getId());
                (rideable).setInUse(false);

            } else
                System.out.println("You cannot dismount");

        }
    }
}