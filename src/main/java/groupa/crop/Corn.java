package groupa.crop;

import groupa.interfaces.Edible;

//done
public class Corn implements Edible {
    private final boolean isEdible = true;

    @Override
    public boolean getIfEdible() {
        return isEdible;
    }
}
