package Prison;

import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Pris_Tbl extends Furniture {
    // ========================================================================
    public Pris_Tbl (Item... items) {
        super(items);
        
        this.description = "It's a heavy wooden dining table sitting in the\n"
                         + "center of the room. It's exceedingly intricate for\n"
                         + "a place like this and does not suit this room.";
        this.searchDialog = "You look on the table.";

        this.addNameKeys("(?:heavy )?(?:wooden )?(?:dining )?table");
    }
    // ========================================================================     
}


