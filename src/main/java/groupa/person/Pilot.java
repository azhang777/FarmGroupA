package groupa.person;


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
                    ((CropDuster) rideable).operate(true);

                }

            }
        } else System.out.println("Pilot is not licenced to mount this");

    }

    @Override
    public void dismount(Rideable rideable) {
        if (rideable instanceof Aircraft) {
            if (rideable instanceof CropDuster) {
                if (rideable.isInUse()) {
                    ((CropDuster) rideable).operate(false);

                }

            } else System.out.println("You never mounted it");

        }
    }

    @Override
    public void makeNoise() {
        System.out.println(getFavPhrase());
    }

    @Override
    public void eat() {
        Basket.getInstance().takeTomato(1);
        Basket.getInstance().takeEgg(2);
        Basket.getInstance().takeCorn(2);
        System.out.println(getName() + " has had a full meal ");

    }
}