package groupa.animal;


import groupa.interfaces.Edible;

//done
public class Egg implements Edible {
   private final boolean isEdible = true;


    @Override
    public boolean getIfEdible() {
        return isEdible;
    }
}
