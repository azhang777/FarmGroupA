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

    /**
     *
     * @param rideable
    The mount method in the Pilot class is responsible for allowing the pilot to mount a rideable object,
    such as an aircraft or a horse. It checks the type of the rideable object and its availability
    before allowing the pilot to mount it.
     */
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

    /**
     *
     * @param rideable
     * The dismount method in the Pilot class is responsible for allowing the pilot to dismount a rideable object,
     * such as an aircraft or a horse. It checks the type of the rideable object and its availability before allowing
     * the pilot to dismount it.
     */
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

    /**
     *
     * @return
     * The isRiding method in the Pilot class is responsible for
     * determining whether the pilot is currently riding a rideable object.
     */
    @Override
    public boolean isRiding() {
        return isRiding;
    }

    /**
     * The makeNoise method in the
     * Pilot class is responsible for printing the favorite phrase of the pilot.
     */
    @Override
    public void makeNoise() {
        System.out.println(getFavPhrase());
    }

    /**
     * The eat method in the Pilot class is responsible for simulating the pilot trying to eat.
     * It calls the takeTomato, takeEgg, and takeCorn methods from the Basket class to remove a specific
     * number of tomatoes, eggs, and corn from the basket
     */
    @Override
    public void eat() {
        System.out.println(getName() + " tries to eat.");
        Basket.getInstance().takeTomato(1);
        Basket.getInstance().takeEgg(2);
        Basket.getInstance().takeCorn(2);
    }
}