package Torture_Chamber;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Torc_Wood extends Furniture {
    // ========================================================================
    public Torc_Wood () {
        super();

        this.description = "The two square wooden beams are tied at the\n"
                         + "center and edges with rope. Both are bloodied.\n"
                         + "Below the center of the device, on the floor,\n"
                         + "is a drain.";

        this.addNameKeys("(?:square )?(?:wooden )?beams?", "drain");
    }
    // ========================================================================    
}

