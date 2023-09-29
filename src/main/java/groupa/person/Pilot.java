package groupa.person;


import groupa.interfaces.Edible;
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
    public void eat(Edible food) {

    }

    /**
     *
     * @param sound
     * Change this when kuma changes his code to avoid and make it "Pilot says something"
     */
    @Override
    public void makeNoise(String sound) {

    }
}