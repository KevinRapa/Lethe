package Library;

import static A_Main.Names.CRYSTAL_ORB;
import A_Super.Item;
import A_Super.Moveable;
import A_Super.SearchableFurniture;
        
public class Lib4_Table extends SearchableFurniture implements Moveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib4_Table(String NAME, Item ... items) {
        super(items);
        this.description = "The low table sits between the couch and the\n"
                         + "fireplace. On its surface is something glinting.";
        this.searchDialog = "You look on the table.";
        this.actDialog = "The table resists any give from the kick you give it.\n"
                       + "It is a solidly built piece of artistry.";
        
        this.addActKeys(JOSTLEPATTERN);
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
