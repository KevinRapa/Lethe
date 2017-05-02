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
        this.actDialog = "If you want this game to start, you better go through "
                       + "the front gate!";
        this.addActKeys("walk", "travel", "run", "use");
        this.addNameKeys("(?:long )?(?:dark )?(?:winding )?(?:path|trail)");
    }
//-----------------------------------------------------------------------------
}
