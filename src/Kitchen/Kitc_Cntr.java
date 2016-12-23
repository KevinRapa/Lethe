package Kitchen;

import A_Super.Furniture;
import A_Super.Item;

public class Kitc_Cntr extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Kitc_Cntr(String NAME, Item ... items) {
        super(items);
        this.description = "The dark oak counters have a nice polished granite\n"
                         + "surface. Beautiful!";
        this.searchDialog = "You comb the counter's surface for things.";
        this.addNameKeys("counter", "counters");
    }
/*----------------------------------------------------------------------------*/
}