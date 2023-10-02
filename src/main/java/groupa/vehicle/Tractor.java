package groupa.vehicle;
import groupa.farm.CropRow;
import groupa.farm.Field;
import groupa.interfaces.FarmVehicle;
import java.util.ArrayList;

public class Tractor extends Vehicle implements FarmVehicle {
    private void harvest(Field field){
        ArrayList<CropRow> cropRows = field.getCropRows();

        for (CropRow cropRow : cropRows) {
            cropRow.harvestAllCrops();
        }

    }


    @Override
    public boolean operate() {
        return false;
    }

    @Override
    public void setInUse() {

    }

    @Override
    public void makeNoise() {

    }
}
