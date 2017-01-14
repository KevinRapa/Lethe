package Servants_Quarters;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.Openable;
        
public class Squa_Dsk extends Furniture implements Openable {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Squa_Dsk(Item... items) {
        super(items);
        this.description = "A plain wooden desk, resting flush against the\n" +
                           "wall. On top is a small lit candle.";
        this.searchDialog = "You slide open the drawer and peer inside.";
        this.actDialog = "You give the desk a small kick. 'It's a good desk...'\n"
                    + "you think to yourself. It's definitely not as\n"
                    + "impressive as that desk in the vestibule, though.";
        this.addNameKeys("(?:plain )?(?:wooden )?desk");
        this.addActKeys("kick");
    }
/*----------------------------------------------------------------------------*/
}
