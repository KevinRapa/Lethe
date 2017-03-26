package Trophy_Room;

import A_Super.Item;
import A_Super.Moveable;
import A_Super.Openable;
import A_Super.SearchableFurniture;

public class Gal5_Display extends SearchableFurniture implements Openable, Moveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal5_Display(Item... items) {
        super(items);
        this.description = "The hinged glass case is dusty and cloudy.";
        this.searchDialog = "Dramatic music queues, you slowly open the display "
                          + "case.";
        this.addNameKeys("(?:hinged )?(?:glass )?(?:display|case)");
    }
/*----------------------------------------------------------------------------*/
}