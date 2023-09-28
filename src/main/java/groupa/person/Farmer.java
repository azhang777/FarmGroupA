package groupa.person;

import groupa.interfaces.Botanist;
import groupa.interfaces.Rider;

public class Farmer extends Person implements Botanist, Rider {
    private boolean isRiding;

    public Farmer(String name, String favPhrase, int age) {
        super(name, favPhrase, age);
    }

    public Farmer(String name, String favPhrase, int age, boolean isRiding) {
        super(name, favPhrase, age);
        this.isRiding = isRiding;
    }

    public boolean isRiding() {
        return isRiding;
    }

    public void setRiding(boolean riding) {
        isRiding = riding;
    }
}