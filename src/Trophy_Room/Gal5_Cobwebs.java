package Trophy_Room;

import A_Super.Furniture;
        
public class Gal5_Cobwebs extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal5_Cobwebs() {
        super();
        this.searchDialog = "You aren't putting your hand near that.";
        this.description = "It's a sticky array of silk harboring many unknown\n"
                         + "dead insects.";
        this.addNameKeys("cobwebs", "cobweb");
    }
/*----------------------------------------------------------------------------*/
}
