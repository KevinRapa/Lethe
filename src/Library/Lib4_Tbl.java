package Library;

import Super.Furniture;
import Super.Item;
        
public class Lib4_Tbl extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib4_Tbl(String NAME, Item ... items) {
        super(NAME, items);
        this.description = "The low table sits between the couch and the\n"
                         + "fireplace. On its surface is something glinting.";
        this.searchDialog = "Looking on the surface of the table, ";
        this.addNameKeys("table");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description;
        
        if (! this.doesThisHaveIt("crystal orb")) {
            rep = "The low table sits between the couch and the\n"
                + "fireplace.";
        } 
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
