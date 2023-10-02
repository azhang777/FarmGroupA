package groupa.vehicle;

import groupa.interfaces.NoiseMaker;
import groupa.interfaces.Rideable;

public abstract class Vehicle implements Rideable, NoiseMaker {
    private boolean inUse = false;
    private String sound;
    private int id;
    public Vehicle(boolean inUse) {
        this.inUse = inUse;
    }

    public Vehicle() {
        this(false);
    }



    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean isInUse() {
        return inUse;
    }


}
