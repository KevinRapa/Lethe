package West_Outer_Wall;

import static A_Main.Names.FIXED_LADDER;
import A_Super.Item;
import A_Main.Player;
import A_Super.Balcony;
import A_Super.Furniture;

public class Wow2_Balcony extends Balcony {
    private final Furniture STRS_REF;
    private final Item LDDR_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wow2_Balcony(Furniture wow2Strs, Item lddr) {
        super();

        this.STRS_REF = wow2Strs;
        this.LDDR_REF = lddr;
        this.description = "You can't see much from down here. The balcony "
                         + "is small and crowded. You can see a door up there "
                         + "against the east wall. You also spot what appears "
                         + "to be a rope on a rack.";

        this.useDialog = "You lean the ladder against the balcony. It's just "
                       + "tall enough.";
        
        this.addNameKeys("(?:small )?(?:crowded )?balcony", "wall");
        this.addUseKeys(FIXED_LADDER);
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        Player.getPos().addFurniture(STRS_REF); // Add the ladder to WOW2.
        Player.getInv().remove(LDDR_REF); // Remove the ladder from player inventory.

        return this.useDialog;
    }
/*----------------------------------------------------------------------------*/
}
