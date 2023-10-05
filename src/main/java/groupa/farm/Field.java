package groupa.farm;

import java.util.ArrayList;

public class Field {

    private ArrayList<CropRow> cropRows;

    public Field() {
        this.cropRows = new ArrayList<>();
    }

    /**
     *
     * @return ArrayList of CropRow
     */
    public ArrayList<CropRow> getCropRows() {
        return cropRows;
    }

    /**
     * Adds cropRow object to ArrayList
     * @param cropRow
     */
    public void addCropRow(CropRow cropRow) {
        cropRows.add(cropRow);
    }
}
