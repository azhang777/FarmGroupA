package groupa.person;

import java.util.Random;

import groupa.interfaces.Rider;

public class Pilot extends Person {


    public void setLisenceId(long lisenceId) {
        this.lisenceId = lisenceId;
    }

    private long lisenceId;

    public Pilot(String name, String favPhrase, int age) {
        super(name, favPhrase, age);
        this.lisenceId = generateRandomLicenseId();
    }

    public long getLisenceId() {
        return lisenceId;
    }

    private long generateRandomLicenseId() {
        Random random = new Random();
        long minLicenseId = 1000000000L;
        long maxLicenseId = 9999999999L;
        return minLicenseId + ((long) (random.nextDouble() * (maxLicenseId - minLicenseId)));
    }
}
