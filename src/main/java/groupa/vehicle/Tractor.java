package groupa.vehicle;

import groupa.interfaces.FarmVehicle;

public class Tractor extends Vehicle implements FarmVehicle {
    @Override
    public void setInUse() {

    }

    @Override
    public boolean operate() {
        return false;
    }
}
