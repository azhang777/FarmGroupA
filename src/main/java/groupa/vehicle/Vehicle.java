package groupa.vehicle;

public abstract class Vehicle {
    private boolean inUse = false;

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public Vehicle(boolean inUse) {
        this.inUse = inUse;
    }

}
