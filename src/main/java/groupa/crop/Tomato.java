package groupa.crop;

import groupa.interfaces.Edible;

//done
public class Tomato implements Edible {
    private final boolean isEdible = true;

    @Override
    public boolean getIfEdible() {
        return isEdible;
    }
}
