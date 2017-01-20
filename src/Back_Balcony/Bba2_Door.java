package Back_Balcony;

import A_Super.Door;
import A_Super.Direction;
/**
 * @author Kevin Rapa
 */
public class Bba2_Door extends Door {
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Bba2_Door (Direction dir) {
        super(dir);
        this.description = "This door looks different from the other doors in\n"
                         + "the castle. It is carved very artfully. At its center,\n"
                         + "a bearded face is carved into the wood.";
    }
/*----------------------------------------------------------------------------*/
}
