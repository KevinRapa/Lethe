package East_Outer_Wall;

import A_Super.Container;
import A_Super.Furniture;
import A_Super.Item;
        
public class Eow2_Cbnt extends Furniture implements Container {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Eow2_Cbnt(Item... items) {
        super(items);
        this.description = "It's a tall pine utility cabinet.";
        this.searchDialog = "You open the cabinet.";
        this.addNameKeys("cabinet", "tall cabinet");
    }
/*----------------------------------------------------------------------------*/
}
