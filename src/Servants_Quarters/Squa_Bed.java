package Servants_Quarters;

import A_Super.Item;
import A_Super.Moveable;
import A_Super.SearchableFurniture;
        
public class Squa_Bed extends SearchableFurniture implements Moveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Squa_Bed (Item... items) {
        super(items);
        this.description = "A plain single bed with a metal frame. The sheets\n"
                         + "are gone.";
        this.searchDialog = "You crouch down and look under the bed.";
        this.actDialog = "It's really not the time for sleeping now.";
        this.addNameKeys("bed", "plain bed", "single bed");
        this.addActKeys(SITPATTERN);
    }
/*----------------------------------------------------------------------------*/
}
