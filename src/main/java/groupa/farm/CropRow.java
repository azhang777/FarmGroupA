package groupa.farm;

import groupa.crop.*;

import java.util.ArrayList;

public class CropRow {
    private static int totalRows;
    private int rowNumber;
    private ArrayList<Crop> crops;

    public CropRow() {
        this.crops = new ArrayList<Crop>();
        rowNumber = totalRows;
        totalRows++;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public ArrayList<Crop> getCrops() {
        return crops;
    }

    public void setCrops(ArrayList<Crop> crops) {
        this.crops = crops;
    }

    public void addCrop(Crop crop) {
        if (rowNumber == 0 && crop instanceof CornStalk) {
            crops.add(crop);
        }
        else if (rowNumber == 1 && crop instanceof TomatoPlant) {
            crops.add(crop);
        }
        else {
            if (crop != null) {
                crops.add(crop);
            } else {
                System.out.println("You are not adding anything");
            }
        }
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
            cropElement.pick(cropElement.yields());
        });
    }
}
