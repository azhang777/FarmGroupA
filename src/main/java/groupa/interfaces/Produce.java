package groupa.interfaces;

public interface Produce {
    /**
     * @return Edible object depending on their hasBeenFertilized flag.
     */
    Edible yields();
}
