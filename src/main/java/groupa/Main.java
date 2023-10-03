package groupa;

import groupa.animal.Chicken;
import groupa.animal.Horse;
import groupa.crop.*;
import groupa.farm.CropRow;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Basket basket = Basket.getInstance();
        CornStalk cornStalk = new CornStalk();
        TomatoPlant tomatoPlant = new TomatoPlant();
        cornStalk.setHasBeenFertilized(true);
        cornStalk.setHasBeenHarvested(true);
        tomatoPlant.setHasBeenFertilized(true);
        tomatoPlant.setHasBeenHarvested(true);

        cornStalk.yield();
        tomatoPlant.yield();
        cornStalk.pick();
        tomatoPlant.pick();
        basket.toString();

        Chicken chicken = new Chicken("Kenny",2,false);
        //running into issues here
        chicken.yield();
        chicken.collectEgg();
        chicken.eat();
        System.out.println("test");
        /*
        works! Basket will retrieve corn and tomato from their arraylist.
        now test takeFrom by calling it from an animal that eats()
         */

        /*
        best solution?: instead of having individual array
         */


        CropRow cropRow = new CropRow(new ArrayList<Crop>());
    }
}
