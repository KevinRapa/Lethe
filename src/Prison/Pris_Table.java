package Prison;

import A_Super.Item;
import A_Super.SearchableFurniture;
import A_Super.Unmoveable;
/**
 * @author Kevin Rapa
 */
public class Pris_Table extends SearchableFurniture implements Unmoveable {
    //-------------------------------------------------------------------------
    public Pris_Table (Item... items) {
        super(items);
        
        this.description = "It's a heavy wooden dining table sitting in the "
                         + "center of the room. It's exceedingly intricate for "
                         + "a place like this and does not suit this room.";
        this.searchDialog = "You look on the table.";

        this.addNameKeys("(?:heavy )?(?:wooden )?(?:dining )?table");
    }
    //-------------------------------------------------------------------------     
}


