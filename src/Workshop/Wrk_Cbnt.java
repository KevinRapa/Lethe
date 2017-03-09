package Workshop;

import A_Super.Item;
import A_Super.Openable;
import A_Super.SearchableFurniture;
import A_Super.Unmoveable;
        
public class Wrk_Cbnt extends SearchableFurniture implements Openable, Unmoveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wrk_Cbnt(Item... items) {
        super(items);
        this.description = "The row of cabinets hang over the workbench.";
        this.searchDialog = "You open the cabinets.";
        this.addNameKeys("cabinet", "cabinets");
    }
/*----------------------------------------------------------------------------*/
}
