package Trophy_Room;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.Container;

public class Gal5_Dsply extends Furniture implements Container {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal5_Dsply(Item... items) {
        super(items);
        this.description = "The hinged glass case is dusty and cloudy.";
        this.searchDialog = "Dramatic music queues, you slowly open the display\n"
                          + "case.";
        this.addNameKeys("(?:hinged )?(?:glass )?(?:display|case)");
    }
/*----------------------------------------------------------------------------*/
}