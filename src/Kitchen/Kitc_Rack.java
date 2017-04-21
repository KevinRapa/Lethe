package Kitchen;

import A_Super.Item;
import A_Super.SearchableFurniture;
        
public class Kitc_Rack extends SearchableFurniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Kitc_Rack(Item... items) {
        super(items);
        this.description = "It's a rack of hooks used to hold keys.";
        this.searchDialog = "You look among the hooks.";
        this.addNameKeys("(?:key )?(?:rack|hooks?)");
    }
//-----------------------------------------------------------------------------
}
