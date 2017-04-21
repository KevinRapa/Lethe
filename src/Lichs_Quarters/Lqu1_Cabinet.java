package Lichs_Quarters;

import A_Super.Item;
import A_Super.Moveable;
import A_Super.Openable;
import A_Super.SearchableFurniture;
/**
 * Holds the dampening staff.
 * 
 * @see Tower.Tow1_Pedestal
 * @author Kevin Rapa
 */
public class Lqu1_Cabinet extends SearchableFurniture implements Openable, Moveable {
    //-------------------------------------------------------------------------
    public Lqu1_Cabinet (Item... items) {
        super(items);
        
        this.description = "It's a standing glass cabinet for displaying "
                         + "weaponry, staffs, brooms, bedposts; long objects.";

        this.searchDialog = "You open the cabinet and look inside.";

        this.addNameKeys("(?:tall )?(?:standing )?(?:glass )?(?:display )?(?:cabinet|case)", 
                "(?:tall )?(?:standing )?(?:glass )?display");
    }
    //-------------------------------------------------------------------------    
}


