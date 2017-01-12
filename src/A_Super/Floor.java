package A_Super;
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
            this.addNameKeys("floor", "ground", "walkway");
    }
/*----------------------------------------------------------------------------*/
}
