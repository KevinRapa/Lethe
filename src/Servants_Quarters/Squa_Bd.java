package Servants_Quarters;

import Super.Furniture;
import Super.Item;
        
public class Squa_Bd extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Squa_Bd (Item... items) {
        super(items);
        this.description = "A plain single bed with a metal frame. The sheets\n"
                         + "are gone.";
        this.searchDialog = "You crouch down and look under the bed.";
        this.interactDialog = "It's really not the time for sleeping now.";
        this.addNameKeys("bed", "plain bed");
        this.addActKeys("sleep", "lay", "relax");
    }
/*----------------------------------------------------------------------------*/
}
