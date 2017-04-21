package Kitchen;

import A_Super.Item;
import A_Super.Openable;
import A_Super.SearchableFurniture;
import A_Super.Unmoveable;
        
public class Kitc_Barrels extends SearchableFurniture 
        implements Openable, Unmoveable 
{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Kitc_Barrels(Item... items) {
        super(items);
        this.description = "The two barrels are open and filled with stale "
                         + "barley and rye.";
        this.searchDialog = "You look into the barrels.";

        this.addNameKeys("barrels?");
    }
//-----------------------------------------------------------------------------
}
