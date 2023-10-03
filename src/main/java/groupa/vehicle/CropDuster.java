package groupa.vehicle;

import groupa.farm.Field;
import groupa.interfaces.FarmVehicle;
import groupa.farm.CropRow;

import java.util.ArrayList;

public class CropDuster extends Aircraft implements FarmVehicle {
    public CropDuster(String sound, int id) {
        super(sound, id);
    }

    /**
     * fertilizes each crop row im a field
     * @param field
     */
    private void fertilize(Field field) {
    ArrayList<CropRow> cropRows = field.getCropRows();
    for (CropRow cropRow : cropRows) {
        cropRow.fertilizeAllCrops();
    }

    }

    /**
     * calls fertilize and checks if cropduster is set in use
     * @param field
     */
    @Override
    public void fly(Field field){
        if (isInUse()) {
            System.out.println("Pilot is now fertilizing field with the crop duster!");
            fertilize(field);
        }
        else {
            System.out.println("No pilot to fertilize field with crop duster!");
        }
    }

    /**
     * sets the cropduster to inuse
     * @param inUse
     */
    @Override
    public void operate(boolean inUse) {
       setInUse(inUse);

    }

    /**
     * plays sound
     */
    @Override
    public void makeNoise() {
        System.out.println(getSound());
    }



}
