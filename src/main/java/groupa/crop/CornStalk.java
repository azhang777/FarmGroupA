package groupa.crop;

import java.util.ArrayList;

//done, maybe change have yield return edible and call yield inside pick to store what yield returns.
public class CornStalk extends Crop {
    //assume when the CornStalk object is create, it has no corn.
    private ArrayList<Corn> corn;

    public CornStalk() {
        super(false, false);
        corn = new ArrayList<>();
    }


    /**
     * if CornStalk fertilized = true (by crop duster operation) && harvested = true (by tractor operation),
     * if true, add new corn to the arrayList corn, set (reset) fertilized and harvested to false, return the new corn.
     * else log that the crop is not ready to be harvested and return null.
     */
    @Override
    public void yield() {
        if (this.checkFertilized() && this.checkHarvested()) {
            Corn newCorn = new Corn();
            corn.add(newCorn);
            this.setHasBeenFertilized(false);
            this.setHasBeenHarvested(false);
        }
        else {
            System.out.println("Corn stalk not ready to be harvested!");
        }
    }

    @Override
    public void pick() {
        Corn cornToAdd = null;
        for (Corn c: corn) {
            if (c != null) {
                cornToAdd = c;
                Basket.getInstance().addTo(cornToAdd);
                corn.remove(c);
                break;
            }
        }
    }
}
