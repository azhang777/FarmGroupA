package groupa.crop;

import groupa.interfaces.Edible;

public class Tomato implements Edible {
    private final boolean isEdible = true;

    @Override
    public boolean getIfEdible() {
        return isEdible;
    }
}
