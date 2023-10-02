package groupa.crop;

import java.util.ArrayList;

public class TomatoPlant extends Crop {

    //assume when the TomatoPlant object is create, it has no tomatoes.
    private ArrayList<Tomato> tomatoes;
    public TomatoPlant() {
        super(false,false);
        tomatoes = new ArrayList<>();
    }

    /** UTILITY FUNCTION -> provide modularity: yield will only return an edible. Now make a function that can store that edible.
     * if TomatoPlant fertilized = true (by crop duster operation) && harvested = true (by tractor operation),
     * if true, add new tomato to the arrayList tomatoes, set (reset) fertilized and harvested to false, return the new tomato.
     * else log that the crop is not ready to be harvested and return null.
     */
    @Override
    public void yield() {
        if (this.checkFertilized() && this.checkHarvested()) {
            Tomato newTomato = new Tomato();
            tomatoes.add(newTomato);
            this.setHasBeenFertilized(false);
            this.setHasBeenHarvested(false);
        }
        else {
            System.out.println("Tomato plant not ready to be harvested!");
        }
    }


    /**
     *
     */
    @Override
    public void pick() {
        Tomato tomatoToAdd = null;
        for (Tomato tomato: tomatoes) {
            if (tomato != null) {
                tomatoToAdd = tomato;
                Basket.getInstance().addTo(tomatoToAdd);
                tomatoes.remove(tomato);
                break;
            }

        }
    }
}
