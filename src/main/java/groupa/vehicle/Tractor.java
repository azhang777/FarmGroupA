package groupa.vehicle;
import groupa.crop.Crop;
import groupa.farm.CropRow;
import groupa.farm.Field;
import groupa.interfaces.FarmVehicle;
import java.util.ArrayList;

public class Tractor extends Vehicle implements FarmVehicle {

    public void harvest(Field field){
        ArrayList<CropRow> cropRows = field.getCropRows();

        for (CropRow cropRow : cropRows) {
            cropRow.harvestAllCrops();
            for (Crop crop : cropRow.getCrops()){
                crop.yield();
                crop.pick();
            }
        }

    }


    @Override
    public void operate(boolean inUse) {
      setInUse(inUse);
    }

    @Override
    public void makeNoise() {
        System.out.println(getSound());

    }
}
