package Trophy_Room;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.Openable;

public class Gal5_Display extends Furniture implements Openable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal5_Display(Item... items) {
        super(items);
        this.description = "The hinged glass case is dusty and cloudy.";
        this.searchDialog = "Dramatic music queues, you slowly open the display\n"
                          + "case.";
        this.addNameKeys("(?:hinged )?(?:glass )?(?:display|case)");
    }
/*----------------------------------------------------------------------------*/
}