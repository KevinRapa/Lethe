package Dining_Room;

import A_Super.SearchableFurniture;
import A_Super.Item;
/**
 * Holds an observatory plate.
 * Discovered by looking behind tapestry.
 * 
 * @see Observatory.Obs_Plt
 * @see Dining_Room.Din1_Tpstry
 * @author Kevin Rapa
 */
public class Din1_Crevice extends SearchableFurniture {
    // ========================================================================
    public Din1_Crevice (Item... items) {
        super(items);

        this.description = "It's a small indentation carved right into the wall!";
        this.searchDialog = "You look in the hole";

        this.addNameKeys("(?:small )?(?:indentation|crevice|hole(?: in the wall)?)");
    }
    // ========================================================================
}


