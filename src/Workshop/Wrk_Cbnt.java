package Workshop;

import Super.Furniture;
import Super.Item;
        
public class Wrk_Cbnt extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wrk_Cbnt(Item... items) {
        super(items);
        this.description = "The row of cabinets hang over the workbench.";
        this.searchDialog = "You open the cabinets.";
        this.interactDialog = "The cabinets are unlocked. Maybe you should search them?";
        this.addActKeys("open");
        this.addNameKeys("cabinet", "cabinets");
    }
/*----------------------------------------------------------------------------*/
}
