package Servants_Quarters;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.Openable;
        
public class Squa_Wardrobe extends Furniture implements Openable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Squa_Wardrobe(Item... items) {
        super(items);
        this.description = "A plain wooden wardrobe.";
        this.searchDialog = "You open the wardrobe.";
        this.addNameKeys("(?:plain )?(?:wooden )?wardrobe");
    }
/*----------------------------------------------------------------------------*/
}
