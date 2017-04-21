package East_Outer_Wall;

import A_Super.Item;
import A_Super.Moveable;
import A_Super.Openable;
import A_Super.SearchableFurniture;
        
public class Eow1_Basket extends SearchableFurniture implements Openable, Moveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Eow1_Basket(Item... items) {
        super(items);
        
        this.description = "It's a tall wicker basket.";
        this.searchDialog = "You take a look in the basket.";
        
        this.addNameKeys("(?:tall )?(?:wicker )?basket");
    }
//-----------------------------------------------------------------------------
}
