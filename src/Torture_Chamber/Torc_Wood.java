package Torture_Chamber;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Torc_Wood extends Furniture {
    //-------------------------------------------------------------------------
    public Torc_Wood () {
        super();

        this.description = "The two square wooden beams are tied at the "
                         + "center and edges with rope. Both are bloodied. "
                         + "Below the center of the device, on the floor, "
                         + "is a drain.";

        this.addNameKeys("(?:square )?(?:wooden )?beams?", "drain");
    }
    //-------------------------------------------------------------------------    
}


