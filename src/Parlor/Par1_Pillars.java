package Parlor;

import A_Super.Furniture;

public class Par1_Pillars extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Par1_Pillars() {
            super();
            this.searchable = false;
            this.addNameKeys("(?:tan )?(?:grooved )?(?:pillars?|columns?)");
            this.description = "The tan, grooved columns support the loft extension.";
    }
/*----------------------------------------------------------------------------*/    
}
