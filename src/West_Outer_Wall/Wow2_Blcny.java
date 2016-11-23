package West_Outer_Wall;

import Super.Item;
import Super.Room;
import Core.Inventory;
import Super.Furniture;

public class Wow2_Blcny extends Furniture {
    private final Furniture REF;
    private final Wow2 REF2;
    private final Inventory REF3;
    private final Item REF4;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wow2_Blcny(String NAME, Furniture wow2Strs, Room wow2, Inventory inv, Item lddr) {
        super(NAME);
        this.searchable = false;
        this.REF = wow2Strs;
        this.REF2 = (Wow2)wow2;
        this.REF3 = inv;
        this.REF4 = lddr;
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
        REF2.addFurniture(REF); // Add the ladder to WOW2.
        REF3.remove(REF4); // Remove the ladder from player inventory.
        
        return this.useDialog;
    }
/*----------------------------------------------------------------------------*/
}
