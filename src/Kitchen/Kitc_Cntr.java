package Kitchen;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.Openable;

public class Kitc_Cntr extends Furniture implements Openable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Kitc_Cntr(Item ... items) {
        super(items);
        this.description = "The dark oak counters have a nice polished granite\n"
                         + "surface. Beautiful! There is a storage area underneath\n"
                         + "the counter.";
        this.searchDialog = "You open the doors under the counter.";
        this.addNameKeys("counters?");
    }
/*----------------------------------------------------------------------------*/
}