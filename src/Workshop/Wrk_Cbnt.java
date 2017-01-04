package Workshop;

import A_Super.Container;
import A_Super.Furniture;
import A_Super.Item;
        
public class Wrk_Cbnt extends Furniture implements Container{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wrk_Cbnt(Item... items) {
        super(items);
        this.description = "The row of cabinets hang over the workbench.";
        this.searchDialog = "You open the cabinets.";
        this.addNameKeys("cabinet", "cabinets");
    }
/*----------------------------------------------------------------------------*/
}
