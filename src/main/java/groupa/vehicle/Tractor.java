package groupa.vehicle;

import groupa.farm.Field;
import groupa.interfaces.FarmVehicle;

public class Tractor extends Vehicle implements FarmVehicle {
    private void harvest(Field field){


    }
    @Override
    public void setInUse() {

    }

    @Override
    public boolean operate() {
        return false;
    }
}
