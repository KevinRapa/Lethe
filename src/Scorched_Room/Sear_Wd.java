package Scorched_Room;

import A_Super.Furniture;
        
public class Sear_Wd extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Sear_Wd(String NAME) {
        super();
        this.searchable = false;
        this.description = "Bits of burnt wood are littered everywhere.";
        this.searchDialog = "It's all just burnt wood.";
        this.addNameKeys("wood");
    }
/*----------------------------------------------------------------------------*/
}
