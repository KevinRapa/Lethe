package Servants_Quarters;

import A_Super.Item;
import A_Super.Moveable;
import A_Super.Openable;
import A_Super.SearchableFurniture;
        
public class Squa_Wardrobe extends SearchableFurniture implements Openable, Moveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Squa_Wardrobe(Item... items) {
        super(items);
        this.description = "A plain wooden wardrobe. It's built so modestly "
                         + "that it nearly brings a tear to your eye. Likely, "
                         + "it was once used by a servant or serf.";
        this.searchDialog = "You open the wardrobe.";
        this.addNameKeys("(?:plain )?(?:wooden )?wardrobe");
    }
//-----------------------------------------------------------------------------
}
