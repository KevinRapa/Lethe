package Trophy_Room;

import Super.Furniture;
import Super.Item;
        
public class Gal5_Cbwbs extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal5_Cbwbs(String NAME, Item ... items) {
        super(NAME, items);
        this.searchable = false;
        this.searchDialog = "You aren't putting your hand near that.";
        this.description = "It's a sticky array of silk harboring many unknown\n"
                         + "dead insects.";
        this.addNameKeys("cobwebs", "cobweb");
    }
/*----------------------------------------------------------------------------*/
}
