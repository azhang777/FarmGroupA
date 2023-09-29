package groupa.crop;

public abstract class Crop {
    private boolean fertilized;
    private boolean harvested;

    public Crop(boolean fertilized, boolean harvested) {
        this.fertilized = fertilized;
        this.harvested = harvested;
    }

    public boolean isFertilized() {
        return fertilized;
    }

    public void setFertilized(boolean fertilized) {
        this.fertilized = fertilized;
    }

    public boolean isHarvested() {
        return harvested;
    }

    public void setHarvested(boolean harvested) {
        this.harvested = harvested;
    }


    public abstract void harvested();
}
