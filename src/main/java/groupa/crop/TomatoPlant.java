package groupa.crop;

import groupa.interfaces.Edible;

public class TomatoPlant extends Crop {

    public TomatoPlant() {
        super(false, false);
    }

    /**
     * Checks if the TomatoPlant is both fertilized and harvested, meaning CropDuster and Tractor
     * has operated on this TomatoPlant. At that point, it is ready to yield its Tomato produce.
     *
     * @return Edible
     */
    @Override
    public Edible yields() {
        if (this.checkFertilized() && this.checkHarvested()) {
            Tomato newTomato = new Tomato();
            this.setHasBeenFertilized(false);
            this.setHasBeenHarvested(false);
            return newTomato;
        } else {
            System.out.println("Tomato plant not ready to be harvested!");
        }
        return null;
    }
}
