package Secret_Stairs;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Sst_Lndng extends Furniture {
    // ========================================================================
    public Sst_Lndng () {
        super();
        this.searchable = false;
        
        this.description = "The stairs lead up to the small landing. It held up\n"
                         + "only by several old wood planks and looks just big\n"
                         + "enough to stand on.";

        this.addNameKeys("landing");
    }
    // ======================================================================== 
}


