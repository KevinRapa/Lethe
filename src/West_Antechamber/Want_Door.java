package West_Antechamber;

import A_Super.Direction;
import A_Super.Door;

public class Want_Door extends Door {
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Want_Door (Direction dir) {
        super(dir);
        this.description = "The door at the bottom of the ramp catches your eye. "
                         + "It's carved very artfully. At its center, a cobra's  "
                         + "head is carved into the wood.";
    }
//-----------------------------------------------------------------------------  
}
