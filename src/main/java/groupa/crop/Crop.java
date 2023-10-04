package groupa.crop;

import groupa.interfaces.Edible;
import groupa.interfaces.Produce;

//done
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

    /**
     * pick allows us to add edible (Tomato/Corn) into the Basket. As long as the Edible object is not null,
     * it is ready and edible. Therefore, add to the Basket.
     *
     * @param edible
     */
    public void pick(Edible edible) {
        if (edible != null) {
            Basket.getInstance().addTo(edible);
        }
    }
}
