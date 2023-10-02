package groupa.farm;

import groupa.crop.Crop;

import java.util.ArrayList;

public class CropRow {
    private ArrayList<Crop> crops;

    public CropRow(ArrayList<Crop> crops) {
        this.crops = crops;
    }

    public ArrayList<Crop> getCrops() {
        return crops;
    }

    public void setCrops(ArrayList<Crop> crops) {
        this.crops = crops;
    }

    /**
     * when crop duster operates, all cropRows in the field will call this method.
     * All crops in cropRow will have their fertilized = true
     */
    public void fertilizeAllCrops() {
        crops.forEach(cropElement -> cropElement.setHasBeenFertilized(true));
    }

    /**
     * when tractor operates, all cropsRows in the field will call this method
     * All crops in cropRow will have their harvested = true
     * All crops will try to be harvested, adding a Tomato or Corn object to
     * Arraylist in TomatoPlant and CornStalk objects respectively.
     */
    public void harvestAllCrops() {
        crops.forEach(cropElement -> {
            cropElement.setHasBeenHarvested(true);
            cropElement.yield();
        });
    }
}
