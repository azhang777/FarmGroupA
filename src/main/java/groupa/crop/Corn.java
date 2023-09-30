package groupa.crop;

import groupa.interfaces.Edible;

public class Corn implements Edible {
    private boolean isEdible;

    @Override
    public boolean getIfEdible() {
        return false;
    }
}
