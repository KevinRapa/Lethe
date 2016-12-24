package West_Outer_Wall;

import A_Super.Item;
import A_Main.Player;
import A_Super.Furniture;

public class Wow2_Blcny extends Furniture {
    private final Furniture STRS_REF;
    private final Item LDDR_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wow2_Blcny(Furniture wow2Strs, Item lddr) {
        super();
        this.searchable = false;
        this.STRS_REF = wow2Strs;
        this.LDDR_REF = lddr;
        this.description = "You can't see much from down here. The balcony\n"
                         + "is small and crowded. You can see a door up there\n"
                         + "against the east wall. You also spot what appears\n"
                         + "to be a rope on a rack.";
        this.searchDialog = "You have to be up there to do that.";
        this.useDialog = "You lean the ladder against the balcony. It's just\n"
                       + "tall enough.";
        this.addNameKeys("balcony");
        this.addUseKeys("fixed ladder");
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        Player.getRoomRef("WOW2").addFurniture(STRS_REF); // Add the ladder to WOW2.
        Player.getInv().remove(LDDR_REF); // Remove the ladder from player inventory.
        
        return this.useDialog;
    }
/*----------------------------------------------------------------------------*/
}
