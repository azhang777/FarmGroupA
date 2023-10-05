package groupa.vehicle;

import groupa.interfaces.NoiseMaker;
import groupa.interfaces.Rideable;

public abstract class Vehicle implements Rideable, NoiseMaker {
    private boolean inUse = false;
    private String sound;
    private long id;
    public Vehicle(String sound, long id) {
        this.sound = sound;
        this.id = id;
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
        return (int) id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean isInUse() {
        return inUse;
    }


}
