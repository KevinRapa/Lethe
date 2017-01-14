package East_Outer_Wall;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.Openable;
        
public class Eow2_Cbnt extends Furniture implements Openable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Eow2_Cbnt(Item... items) {
        super(items);
        this.description = "It's a tall pine utility cabinet.";
        this.searchDialog = "You open the cabinet.";
        this.addNameKeys("(?:tall )?(?:pine |wood(?:en)? )?(?:utility )?cabinet");
    }
/*----------------------------------------------------------------------------*/
}
