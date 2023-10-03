package groupa.vehicle;

import groupa.farm.Field;

public abstract class Aircraft extends Vehicle{
    public Aircraft(String sound, int id) {
        super(sound, id);
    }

    public abstract void fly(Field field);
}
