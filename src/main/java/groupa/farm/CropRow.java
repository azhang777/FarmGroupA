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

    /**
     * Conditions for row 0 and 1 since they can only have CornStalk and TomatoPlant respectively. If it is any other row,
     * we can add any type of Crop.
     *
     * @param crop
     */
    public void addCrop(Crop crop) {
        if (rowNumber == 0 && crop instanceof CornStalk) {
            crops.add(crop);
        } else if (rowNumber == 1 && crop instanceof TomatoPlant) {
            crops.add(crop);
        } else {
            if (crop != null) {
                crops.add(crop);
            } else {
                System.out.println("You are not adding anything");
            }
        }
    }

    /**
     * When crop duster operates, all cropRows in the field will call this method.
     * All crops in cropRow will have their fertilized = true
     */
    public void fertilizeAllCrops() {
        crops.forEach(cropElement -> cropElement.setHasBeenFertilized(true));
    }

    /**
     * When tractor operates, all cropsRows in the field will call this method
     * All crops in cropRow will have their harvested = true
     * Then we yield each crop element. If yields returns a non-null object, add it to Basket.
     */
    public void harvestAllCrops() {
        crops.forEach(cropElement -> {
            cropElement.setHasBeenHarvested(true);
            cropElement.pick(cropElement.yields());
        });
    }
}
