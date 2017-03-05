package East_Outer_Wall;

import A_Super.Item;
import A_Super.SearchableFurniture;
        
public class Eow1_Rack extends SearchableFurniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Eow1_Rack(Item... items) {
        super(items);
        this.description = "It's a plain weapon rack.";
        this.searchDialog = "You take a look at its contents.";
        this.actDialog = "Are we being lazy and not searching the rack first?";
        this.addActKeys(GETPATTERN);
        this.addNameKeys("(?:plain )?(?:weapon )?rack", "weapons?");
    }
/*----------------------------------------------------------------------------*/
}
