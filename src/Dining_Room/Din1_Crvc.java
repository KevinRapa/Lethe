package Dining_Room;

import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Din1_Crvc extends Furniture {
    // ========================================================================
    public Din1_Crvc (Item... items) {
        super(items);

        this.description = "It's a small indentation carved right into the wall!";
        this.searchDialog = "You look in the hole";

        this.addNameKeys("(?:small )?(?:indentation|crevice|hole(?: in the wall)?)");
    }
    // ========================================================================
}


