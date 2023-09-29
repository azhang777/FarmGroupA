package groupa.vehicle;

import groupa.farm.Field;
import groupa.interfaces.FarmVehicle;

public class CropDuster extends Aircraft implements FarmVehicle {
    private void fertilize(Field field){


    }
    @Override
    public boolean operate() {
        return false;
    }
}
