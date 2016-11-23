package Servants_Quarters;

import Super.Furniture;
import Super.Item;
        
public class Squa_Wrdrb extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Squa_Wrdrb(String NAME, Item ... items) {
        super(NAME, items);
        this.description = "A plain wooden wardrobe.";
        this.searchDialog = "You open the wardrobe.";
        this.interactDialog = "The wardrobe is unlocked. Maybe you should search it?";
        this.addNameKeys("wardrobe");
        this.addActKeys("open");
    }
/*----------------------------------------------------------------------------*/
}
