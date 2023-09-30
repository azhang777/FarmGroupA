package groupa.crop;

import java.util.ArrayList;

public class CornStalk extends Crop{
    private ArrayList<Corn> corn;

    public CornStalk(boolean fertilized, boolean harvested) {
        super(fertilized, harvested);
    }

    /**
     * if CornStalk fertilized = true (by crop duster operation) && harvested = true (by tractor operation), this method will
     * add a new corn object into the arrayList corn. It will then set harvested and fertilized to false, resetting the process.
     */
    @Override
    public void harvested() {
        if (this.isFertilized() && this.isHarvested()) {
            this.corn.add(new Corn());
        }
        this.setHarvested(false);
        this.setFertilized(false);
    }

}
