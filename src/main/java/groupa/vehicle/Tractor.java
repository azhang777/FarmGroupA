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

    /**
     * The harvest method in the Tractor class is responsible for harvesting all the crops in a given field.
     * It checks if the tractor is in use and then iterates over each crop row in the field, calling the harvestAllCrops method on each crop row
     * @param field
     */
    public void harvest(Field field){

        if (isInUse()) {
            System.out.println("Farmer is now harvesting the field with the tractor!");
            ArrayList<CropRow> cropRows = field.getCropRows();

            for (CropRow cropRow : cropRows) {
                cropRow.harvestAllCrops();
            }
        }
        else {
            System.out.println("No rider to harvest field with tractor!");
        }


    }

    /**
     * this sets the tractor in use
     * @param inUse
     */
    @Override
    public void operate(boolean inUse) {
      setInUse(inUse);
    }

    /**
     * this plays the tractor sound
     */
    @Override
    public void makeNoise() {
        System.out.println(getSound());

    }
}
