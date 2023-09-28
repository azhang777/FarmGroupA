package groupa.vehicle;

import groupa.interfaces.Rideable;

public abstract class Vehicle implements Rideable {
    private boolean inUse = false;

    public Vehicle() {
        this(false);
    }



    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    @Override
    public boolean isInUse() {
        return inUse;
    }
    public Vehicle(boolean inUse) {
        this.inUse = inUse;
    }

}
