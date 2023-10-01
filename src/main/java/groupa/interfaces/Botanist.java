package groupa.interfaces;

import groupa.crop.Crop;
import groupa.farm.CropRow;

public interface Botanist {
  /**
   *
   * @param crop
   * @param cropRow
   * allows farmer to plant a single crop on an existing crop row.
   */
  void plant (Crop crop, CropRow cropRow);
}
