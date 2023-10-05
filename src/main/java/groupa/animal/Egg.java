package groupa.animal;


import groupa.interfaces.Edible;

public class Egg implements Edible {
   private final boolean isEdible = true;

    /**
     * The getIfEdible method in the Egg class returns the value of the isEdible variable, indicating whether the egg is edible or not.
     */
    @Override
    public boolean getIfEdible() {
        return isEdible;
    }
}
