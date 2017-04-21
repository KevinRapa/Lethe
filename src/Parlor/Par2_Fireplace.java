package Parlor;

import A_Super.Furniture;

public class Par2_Fireplace extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Par2_Fireplace() {
            super();

            this.addNameKeys("fireplace", "hearth");
            this.description = "The fireplace crackles down below. Who keeps these "
                             + "things lit?";
            this.searchDialog = "It's much too far away to do that...";
    }
//-----------------------------------------------------------------------------    
}
