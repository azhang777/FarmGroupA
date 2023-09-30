package groupa.crop;

import java.util.ArrayList;

public class TomatoPlant extends Crop {
    private ArrayList<Tomato> tomatoes;

    public TomatoPlant(boolean fertilized, boolean harvested) {
        super(fertilized, harvested);
    }

    /**
     * if TomatoPlant fertilized = true (by crop duster operation) && harvested = true (by tractor operation), this method will
     * add a new corn object into the arrayList corn. It will then set harvested and fertilized to false, resetting the process.
     */
    @Override
    public void harvested() {
        if (this.isFertilized() && this.isHarvested()) {
            this.tomatoes.add(new Tomato());
        }
        this.setHarvested(false);
        this.setFertilized(false);
    }


}
