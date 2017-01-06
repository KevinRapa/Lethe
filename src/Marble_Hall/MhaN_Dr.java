package Marble_Hall;

import A_Super.Direction;
import A_Super.Door;

public class MhaN_Dr extends Door {
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public MhaN_Dr (Direction dir) {
        super(dir);
        this.description = "The door is painted white and accented in gold. Nailed in\n"
                         + "the center is a gold cross.";
        this.addNameKeys("(?:gold )?cross");
    }
/*----------------------------------------------------------------------------*/
}
