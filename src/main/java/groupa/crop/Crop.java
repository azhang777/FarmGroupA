package groupa.crop;

import groupa.interfaces.Edible;
import groupa.interfaces.Produce;

public abstract class Crop implements Produce {
    private boolean hasBeenFertilized;
    private boolean hasBeenHarvested;

    public Crop(boolean hasBeenFertilized, boolean hasBeenHarvested) {
        this.hasBeenFertilized = hasBeenFertilized;
        this.hasBeenHarvested = hasBeenHarvested;
    }

    public boolean checkFertilized() {
        return hasBeenFertilized;
    }

    public void setHasBeenFertilized(boolean hasBeenFertilized) {
        this.hasBeenFertilized = hasBeenFertilized;
    }

    public boolean checkHarvested() {
        return hasBeenHarvested;
    }

    public void setHasBeenHarvested(boolean hasBeenHarvested) {
        this.hasBeenHarvested = hasBeenHarvested;
    }

    public abstract Edible pick();
}
