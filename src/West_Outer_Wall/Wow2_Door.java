package West_Outer_Wall;

import A_Super.Direction;
import A_Super.Door;

public class Wow2_Door extends Door {
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Wow2_Door (Direction dir) {
        super(dir);
        this.description = "To your east, you inspect the door. It's in horrible\n"
                         + "condition. It's boarded shut, and numerous gashes and\n"
                         + "splinters cover it. A hole in the door is big enough\n"
                         + "to see through.";
        this.actDialog = "Not even someone as burly as yourself could pull these\n"
                            + "boards off.";
    }
/*----------------------------------------------------------------------------*/
}