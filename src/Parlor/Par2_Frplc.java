package Parlor;

import A_Super.Furniture;

public class Par2_Frplc extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Par2_Frplc() {
            super();
            this.searchable = false;
            this.addNameKeys("fireplace", "hearth");
            this.description = "The fireplace crackles down below. Who keeps these\n"
                             + "things lit?";
            this.searchDialog = "It's much too far away to do that...";
    }
/*----------------------------------------------------------------------------*/    
}
