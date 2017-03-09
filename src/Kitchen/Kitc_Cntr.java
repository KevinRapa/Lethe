package Kitchen;

import A_Super.Item;
import A_Super.Openable;
import A_Super.SearchableFurniture;
import A_Super.Unmoveable;

public class Kitc_Cntr extends SearchableFurniture implements Openable, Unmoveable {
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