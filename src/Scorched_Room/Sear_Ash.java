package Scorched_Room;

import A_Super.Furniture;
        
public class Sear_Ash extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Sear_Ash() {
        super();

        this.description = "The ash is scattered all over the floor.";
        this.searchDialog = "Nothing here but more ash.";
        this.addNameKeys("ash", "ashes");
    }
/*----------------------------------------------------------------------------*/
}