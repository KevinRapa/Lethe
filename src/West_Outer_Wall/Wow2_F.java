package West_Outer_Wall;

import static A_Main.NameConstants.FIXED_LADDER;
import A_Main.Player;
import A_Super.Floor;
import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Wow2_F extends Floor {
    private final Furniture STRS_REF;
    private final Item LDDR_REF;
    // ========================================================================
    public Wow2_F (Furniture wow2Strs, Item lddr, Item... items) {
        super("A sandstone tiled floor.", items);
        
        this.STRS_REF = wow2Strs;
        this.LDDR_REF = lddr;
        this.useDialog = "You stand the ladder on the floor leaning against the balcony.";
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        Player.getPos().addFurniture(STRS_REF); // Add the ladder to WOW2.
        Player.getInv().remove(LDDR_REF); // Remove the ladder from player inventory.

        return this.useDialog;
    }
    // ========================================================================     
}


