package groupa.crop;

import groupa.interfaces.Edible;

import java.util.ArrayList;

public class TomatoPlant extends Crop {
    private ArrayList<Tomato> tomatoes;

    public TomatoPlant(boolean fertilized, boolean harvested) {
        super(fertilized, harvested);
    }

    /**
     * if TomatoPlant fertilized = true (by crop duster operation) && harvested = true (by tractor operation), this method will
     * add a new corn object into the arrayList corn. If successfully harvested, set both fertilized and harvested to false.
     * else sout that the crop is not ready to be harvested.
     */
    @Override
    public Edible yield() {
        if (this.checkFertilized() && this.checkHarvested()) {
            this.tomatoes.add(new Tomato());
            this.setHasBeenFertilized(false);
            this.setHasBeenHarvested(false);
        }
        else {
            System.out.println("Not ready to be harvested!");
        }
        return null;
    }
}
