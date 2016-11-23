package East_Outer_Wall;

import Super.Furniture;
import Super.Item;
        
public class Eow2_Cbnt extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Eow2_Cbnt(String NAME, Item ... items) {
        super(NAME, items);
        this.description = "It's a tall pine utility cabinet.";
        this.searchDialog = "You open the cabinet.";
        this.interactDialog = "The cabinet is unlocked. Maybe you should search it?";
        this.addActKeys("open");
        this.addNameKeys("cabinet", "tall cabinet");
    }
/*----------------------------------------------------------------------------*/
}
