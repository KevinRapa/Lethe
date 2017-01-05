package Courtyard;

import A_Super.Furniture;

public class Cou4_Trl extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou4_Trl() {
        super();
        this.searchable = false;
        this.description = "The winding trail extends back into the dark forest.";
        this.actDialog = "You feel compelled to enter through the front gate.";
        this.addActKeys("walk");
        this.addNameKeys("(?:long )?(?:dark )?(?:winding )?trail");
    }
/*----------------------------------------------------------------------------*/
}
