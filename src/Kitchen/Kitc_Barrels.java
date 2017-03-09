package Kitchen;

import A_Super.Heavy;
import A_Super.Item;
import A_Super.Openable;
import A_Super.SearchableFurniture;
        
public class Kitc_Barrels extends SearchableFurniture implements Openable, Heavy {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Kitc_Barrels(Item... items) {
        super(items);
        this.description = "The two barrels are open and filled with stale\n"
                         + "barley and rye.";
        this.searchDialog = "You look into the barrels.";

        this.addNameKeys("barrels?");
    }
/*----------------------------------------------------------------------------*/
}
