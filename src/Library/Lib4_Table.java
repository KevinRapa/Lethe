package Library;

import static A_Main.NameConstants.CRYSTAL_ORB;
import A_Super.Furniture;
import A_Super.Item;
        
public class Lib4_Table extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib4_Table(String NAME, Item ... items) {
        super(items);
        this.description = "The low table sits between the couch and the\n"
                         + "fireplace. On its surface is something glinting.";
        this.searchDialog = "You look on the table.";
        this.addNameKeys("(?:low )?table", "(?:glimmering )?object");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (! this.containsItem(CRYSTAL_ORB)) {
            return "The low table sits between the couch and the fireplace.";
        } 
        else
            return this.description;
    }
/*----------------------------------------------------------------------------*/
}
