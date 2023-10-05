package groupa.crop;

import groupa.interfaces.Edible;

public class CornStalk extends Crop {

    public CornStalk() {
        super(false, false);
    }


    /**
     * Checks if the CornStalk is both fertilized and !harvested, meaning CropDuster and Tractor
     * has operated on this CornStalk. At that point, it is ready to yield its Corn produce.
     *
     * @return Edible
     */
    @Override
    public Edible yields() {
        if (this.checkFertilized() && !this.checkHarvested()) {
            Corn newCorn = new Corn();
            this.setHasBeenFertilized(false);
            return newCorn;
        } else {
            System.out.println("Corn stalk not ready to be harvested!");
        }
        return null;
    }
}
