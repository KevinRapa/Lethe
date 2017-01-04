package Servants_Quarters;

import A_Super.Furniture;
import A_Super.Item;
        
public class Squa_Bd extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Squa_Bd (Item... items) {
        super(items);
        this.description = "A plain single bed with a metal frame. The sheets\n"
                         + "are gone.";
        this.searchDialog = "You crouch down and look under the bed.";
        this.actDialog = "It's really not the time for sleeping now.";
        this.addNameKeys("bed", "plain bed", "single bed");
        this.addActKeys("sleep", "lay", "relax");
    }
/*----------------------------------------------------------------------------*/
}
