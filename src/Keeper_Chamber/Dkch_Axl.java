package Keeper_Chamber;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Dkch_Axl extends Furniture {
    // ========================================================================
    public Dkch_Axl () {
        super();
        this.searchable = false;
        
        this.description = "The wooden axle spins only a couple feet from your\n"
                         + "head. 'This is dangerous!' You think to yourself.";

        this.addNameKeys("(?:wooden )?(?:spinning )?(?:axle|shaft|driveshaft)");
    }
    // ======================================================================== 
}


