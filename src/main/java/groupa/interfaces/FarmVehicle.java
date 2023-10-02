package groupa.interfaces;

public interface FarmVehicle {
    /**
     *
     * @return boolean
     * if vehicle is in use by farmer/pilot, it is able to harvest/fertilize
     * the field of crop rows. If vehicle is not in use, it cannot operate on the
     * field and return false.
     */
   public void operate(boolean inUse);
}
