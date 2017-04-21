package East_Outer_Wall;

import A_Super.Item;
import A_Super.Moveable;
import A_Super.Openable;
import A_Super.SearchableFurniture;
        
public class Eow2_Cabinet extends SearchableFurniture implements Openable, Moveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Eow2_Cabinet(Item... items) {
        super(items);
        this.description = "It's a tall pine utility cabinet.";
        this.searchDialog = "You open the cabinet.";
        this.addNameKeys("(?:tall )?(?:pine |wood(?:en)? )?(?:utility )?cabinet");
    }
//-----------------------------------------------------------------------------
}
