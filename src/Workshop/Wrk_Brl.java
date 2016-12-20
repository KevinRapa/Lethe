package Workshop;

import Super.Furniture;
import Super.Item;
        
public class Wrk_Brl extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wrk_Brl(Item... items) {
        super(items);
        this.description = "It's not full sized... maybe only three feet high.\n"
                         + "It has a wooden lid on top.";
        this.searchDialog = "You open the lid and peer inside.";
        this.interactDialog = "That sounds like a terrible idea. Better search the barrel instead.";
        this.addActKeys("open");
        this.addNameKeys("barrel");
    }
/*----------------------------------------------------------------------------*/
}
