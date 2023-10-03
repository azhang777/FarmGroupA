package groupa.vehicle;
import groupa.crop.Crop;
import groupa.farm.CropRow;
import groupa.farm.Field;
import groupa.interfaces.FarmVehicle;
import java.util.ArrayList;

public class Tractor extends Vehicle implements FarmVehicle {

    public Tractor(String sound, int id) {
        super(sound, id);
    }

    public void harvest(Field field){

        if (isInUse()) {
            System.out.println("Farmer is now harvesting the field with the tractor!");
            ArrayList<CropRow> cropRows = field.getCropRows();

            for (CropRow cropRow : cropRows) {
                cropRow.harvestAllCrops();
                for (Crop crop : cropRow.getCrops()){
                    crop.yield();
                    crop.pick();
                }
            }
        }
        else {
            System.out.println("No rider to harvest field with tractor!");
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
