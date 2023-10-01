package groupa.crop;

import groupa.interfaces.Edible;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class TomatoPlant extends Crop {

    //assume when the TomatoPlant object is create, it has no tomatoes.
    private ArrayList<Tomato> tomatoes;

    public TomatoPlant() {
        super(false,false);
    }

    /**
     * if TomatoPlant fertilized = true (by crop duster operation) && harvested = true (by tractor operation),
     * if true, add new tomato to the arrayList tomatoes, set (reset) fertilized and harvested to false, return the new tomato.
     * else log that the crop is not ready to be harvested and return null.
     */
    @Override
    public Edible yield() {
        if (this.checkFertilized() && this.checkHarvested()) {
            Tomato newTomato = new Tomato();
            this.tomatoes.add(newTomato);
            this.setHasBeenFertilized(false);
            this.setHasBeenHarvested(false);
            return newTomato;
        }
        else {
            System.out.println("Tomato plant not ready to be harvested!");
            return null;
        }
    }

    /**
     *
     * @return Tomato
     * come back to later, we are grabbing the nearest tomato but not sorting it.
     */
    @Override
    public Tomato pick() {
        Tomato tomatoToAdd = null;
        for (Tomato tomato: tomatoes) {
            if (tomato != null) {
                tomatoToAdd = tomato;
                tomatoes.remove(tomato);
            }

        }
        return tomatoToAdd;
    }
}
