package groupa.crop;

import java.util.ArrayList;

public class TomatoPlant extends Crop {
    private ArrayList<Tomato> tomatoes;

    public TomatoPlant(boolean fertilized, boolean harvested) {
        super(fertilized, harvested);
    }

    @Override
    public void harvested() {
        if (this.isFertilized() && this.isHarvested()) {
            this.tomatoes.add(new Tomato());
        }
        this.setHarvested(false);
        this.setFertilized(false);
    }


}
