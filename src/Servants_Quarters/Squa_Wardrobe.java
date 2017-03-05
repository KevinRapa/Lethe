package Servants_Quarters;

import A_Super.Item;
import A_Super.Openable;
import A_Super.SearchableFurniture;
        
public class Squa_Wardrobe extends SearchableFurniture implements Openable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Squa_Wardrobe(Item... items) {
        super(items);
        this.description = "A plain wooden wardrobe. It's built so modestly\n"
                         + "that it nearly brings a tear to your eye. Likely,\n"
                         + "it was once used by a servant or serf.";
        this.searchDialog = "You open the wardrobe.";
        this.addNameKeys("(?:plain )?(?:wooden )?wardrobe");
    }
/*----------------------------------------------------------------------------*/
}
