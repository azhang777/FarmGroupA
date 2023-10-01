package groupa.crop;

import groupa.interfaces.Edible;

import java.util.ArrayList;

public class CornStalk extends Crop {
    //assume when the CornStalk object is create, it has no corn.
    private ArrayList<Corn> corn;

    public CornStalk() {
        super(false, false);
    }


    /**
     * if CornStalk fertilized = true (by crop duster operation) && harvested = true (by tractor operation),
     * if true, add new corn to the arrayList corn, set (reset) fertilized and harvested to false, return the new corn.
     * else log that the crop is not ready to be harvested and return null.
     */
    @Override
    public Edible yield() {
        if (this.checkFertilized() && this.checkHarvested()) {
            Corn newCorn = new Corn();
            this.corn.add(newCorn);
            this.setHasBeenFertilized(false);
            this.setHasBeenHarvested(false);
            return newCorn;
        }
        else {
            System.out.println("Corn stalk not ready to be harvested!");
            return null;
        }
    }

    @Override
    public Corn pick() {
        Corn cornToAdd = null;
        for (Corn c: corn) {
            if (c != null) {
                cornToAdd = c;
                corn.remove(c);
            }

        }
        return cornToAdd;
    }
}
