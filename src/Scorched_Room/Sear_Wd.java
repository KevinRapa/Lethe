package Scorched_Room;

import Super.Furniture;
        
public class Sear_Wd extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Sear_Wd(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "Bits of burnt wood are littered everywhere.";
        this.searchDialog = "It's all just burnt wood.";
        this.addNameKeys("wood");
    }
/*----------------------------------------------------------------------------*/
}
