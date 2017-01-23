package Courtyard;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Cou4_Trail extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou4_Trail() {
        super();

        this.description = "The winding trail extends back into the dark forest.";
        this.actDialog = "You feel compelled to enter through the front gate.";
        this.addActKeys("walk");
        this.addNameKeys("(?:long )?(?:dark )?(?:winding )?trail");
    }
/*----------------------------------------------------------------------------*/
}
