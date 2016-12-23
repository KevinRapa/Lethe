package Workshop;

import A_Super.Container;
import A_Super.Furniture;
import A_Super.Item;
        
public class Wrk_Brl extends Furniture implements Container {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wrk_Brl(Item... items) {
        super(items);
        this.description = "It's not full sized... maybe only three feet high.\n"
                         + "It has a wooden lid on top.";
        this.searchDialog = "You open the lid and peer inside.";
        this.addNameKeys("barrel");
    }
/*----------------------------------------------------------------------------*/
}
