package Kampe_Quarters;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Dkch_Axle extends Furniture {
    //-------------------------------------------------------------------------
    public Dkch_Axle () {
        super();

        this.actDialog = "That is dangerous and unecessary.";
        this.description = "The wooden axle spins only a couple feet from your "
                         + "head.";

        this.addActKeys("stop");
        this.addNameKeys("(?:wooden )?(?:spinning )?(?:axle|shaft|driveshaft)");
    }
    //------------------------------------------------------------------------- 
}


