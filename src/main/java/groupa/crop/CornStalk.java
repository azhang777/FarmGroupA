package groupa.crop;

import java.util.ArrayList;

public class CornStalk extends Crop{
    private ArrayList<Corn> corn;

    public CornStalk(boolean fertilized, boolean harvested) {
        super(fertilized, harvested);
    }

    @Override
    public boolean hasBeenHarvested() {
        return false;
    }
}
