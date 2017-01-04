package Library;

import A_Super.Furniture;
import A_Super.Item;
        
public class Lib4_Tbl extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib4_Tbl(String NAME, Item ... items) {
        super(items);
        this.description = "The low table sits between the couch and the\n"
                         + "fireplace. On its surface is something glinting.";
        this.searchDialog = "You look on the table.";
        this.addNameKeys("(?:low )?table", "(?:glimmering )?object");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (! this.doesThisHaveIt("crystal orb")) {
            return "The low table sits between the couch and the\n"
                 + "fireplace.";
        } 
        return this.description;
    }
/*----------------------------------------------------------------------------*/
}
