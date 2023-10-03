package groupa.person;


import groupa.animal.Horse;
import groupa.crop.Basket;
import groupa.interfaces.Edible;
import groupa.interfaces.FarmVehicle;
import groupa.interfaces.Rideable;
import groupa.interfaces.Rider;
import groupa.vehicle.Aircraft;
import groupa.vehicle.CropDuster;
import groupa.vehicle.Vehicle;


public class Pilot extends Person implements Rider {

    private long licenseId;
    private static long counter;
    private boolean isRiding;

    public Pilot(String name, String favPhrase, int age) {
        super(name, favPhrase, age);
        counter++;
        this.licenseId = counter;
    }

    public long getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(long licenseId) {
        this.licenseId = licenseId;
    }

    @Override
    public void mount(Rideable rideable) {
        if (rideable instanceof Aircraft) {
            if (rideable instanceof CropDuster) {
                if (!rideable.isInUse()) {
                    System.out.println(getName() + " is now operating the vehicle under #" + ((CropDuster) rideable).getId());
                    ((CropDuster) rideable).operate(true);
                    isRiding = true;
                }
            }
        } else if (rideable instanceof Horse) {
            if (!rideable.isInUse()) {
                (rideable).setInUse(true);
                isRiding = true;
            }
        }
        else System.out.println("Pilot is not licenced to mount this");

    }

    @Override
    public void dismount(Rideable rideable) {
        if (rideable instanceof Aircraft) {
            if (rideable instanceof CropDuster) {
                if (rideable.isInUse()) {
                    System.out.println(getName() + " is leaving the vehicle under " + ((CropDuster) rideable).getId());
                    ((CropDuster) rideable).operate(false);
                    isRiding = false;
                }
            }

        } else if (rideable instanceof Horse) {
            if (rideable.isInUse()) {
                (rideable).setInUse(false);
                isRiding = false;
            }
        }else System.out.println("You never mounted it");
    }

    @Override
    public boolean isRiding() {
        return isRiding;
    }

    @Override
    public void makeNoise() {
        System.out.println(getFavPhrase());
    }

    @Override
    public void eat() {
        System.out.println(getName() + " tries to eat.");
        Basket.getInstance().takeTomato(1);
        Basket.getInstance().takeEgg(2);
        Basket.getInstance().takeCorn(2);
    }
}