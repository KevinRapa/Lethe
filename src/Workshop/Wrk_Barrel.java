package Workshop;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.Openable;
        
public class Wrk_Barrel extends Furniture implements Openable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wrk_Barrel(Item... items) {
        super(items);
        this.description = "It's not full sized... maybe only three feet high.\n"
                         + "It has a wooden lid on top.";
        this.searchDialog = "You open the lid and peer inside.";
        this.addNameKeys("barrel");
    }
/*----------------------------------------------------------------------------*/
}
