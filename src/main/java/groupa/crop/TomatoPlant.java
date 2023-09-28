package groupa.crop;

import java.util.ArrayList;

public class TomatoPlant extends Crop{
    private ArrayList<Tomato> tomato;

    public TomatoPlant(boolean fertilized, boolean harvested) {
        super(fertilized, harvested);
    }

    @Override
    public boolean hasBeenHarvested() {
        return false;
    }
}
