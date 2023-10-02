package groupa.vehicle;

import groupa.farm.Field;
import groupa.interfaces.FarmVehicle;
import groupa.farm.CropRow;

import java.util.ArrayList;

public class CropDuster extends Aircraft implements FarmVehicle {
    private void fertilize(Field field){
    ArrayList<CropRow> cropRows = field.getCropRows();
    for (CropRow cropRow : cropRows) {
        cropRow.fertilizeAllCrops();
    }

    }
    @Override
    public boolean operate() {
        fly();

        return true;
    }

    @Override
    public void makeNoise() {

    }

    @Override
    public void setInUse() {

    }
}
