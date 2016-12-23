package Servants_Quarters;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.Container;
        
public class Squa_Wrdrb extends Furniture implements Container {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Squa_Wrdrb(Item... items) {
        super(items);
        this.description = "A plain wooden wardrobe.";
        this.searchDialog = "You open the wardrobe.";
        this.addNameKeys("wardrobe");
    }
/*----------------------------------------------------------------------------*/
}
