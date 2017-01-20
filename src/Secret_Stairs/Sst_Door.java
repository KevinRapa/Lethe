package Secret_Stairs;

import A_Super.Direction;
import A_Super.Door;

public class Sst_Door extends Door {
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Sst_Door (Direction dir) {
        super(dir);
        this.description = "This door is weathered and merely just vertical wood\n"
                         + "slats accompanied by a plain black iron doorknob.";
    }
/*----------------------------------------------------------------------------*/
}
