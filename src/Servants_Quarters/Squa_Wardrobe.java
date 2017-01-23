package Servants_Quarters;

import A_Super.Item;
import A_Super.Openable;
import A_Super.SearchableFurniture;
        
public class Squa_Wardrobe extends SearchableFurniture implements Openable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Squa_Wardrobe(Item... items) {
        super(items);
        this.description = "A plain wooden wardrobe.";
        this.searchDialog = "You open the wardrobe.";
        this.addNameKeys("(?:plain )?(?:wooden )?wardrobe");
    }
/*----------------------------------------------------------------------------*/
}
