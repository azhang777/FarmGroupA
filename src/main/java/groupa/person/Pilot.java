package groupa.person;


import groupa.crop.Basket;
import groupa.interfaces.Edible;
import groupa.interfaces.Rideable;
import groupa.interfaces.Rider;


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

    }

    @Override
    public void dismount(Rideable rideable) {

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