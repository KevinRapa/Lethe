package Trophy_Room;

import Super.Furniture;
import Super.Item;

public class Gal5_Dsply extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal5_Dsply(Item... items) {
        super(items);
        this.description = "The hinged glass case is dusty and cloudy.";
        this.searchDialog = "Dramatic music queues, you slowly open the display\n"
                          + "case.";
        this.interactDialog = "The cabinet is unlocked. Maybe you should search it?";
        this.addActKeys("open");
        this.addNameKeys("glass display", "display");
    }
/*----------------------------------------------------------------------------*/
}