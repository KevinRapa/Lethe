package A_Super;

import static A_Main.NameConstants.FIXED_LADDER;

/**
 * Represents the floor or ground in a room.
 * Superficial, though items may be stored here if needed.
 * 
 * @author Kevin Rapa
 */
public class Floor extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Floor(String dsc, Item... items) {
            super(items);
            this.description = dsc;
            this.searchDialog = "You crouch down and scan the ground.";
            this.useDialog = "There's no reason to stand the ladder up in here.";
            this.addUseKeys(FIXED_LADDER);
            this.addNameKeys("floor", "ground", "walkway");
    }
/*----------------------------------------------------------------------------*/
}
