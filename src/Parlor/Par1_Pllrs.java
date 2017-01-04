package Parlor;

import A_Super.Furniture;

public class Par1_Pllrs extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Par1_Pllrs() {
            super();
            this.searchable = false;
            this.addNameKeys("(?:tan )?(?:grooved )?(?:pillars?|columns?)");
            this.description = "The tan, grooved columns support the loft extension.";
    }
/*----------------------------------------------------------------------------*/    
}
