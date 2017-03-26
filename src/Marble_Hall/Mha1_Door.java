package Marble_Hall;

import A_Super.Direction;
import A_Super.Door;

public class Mha1_Door extends Door {
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Mha1_Door (Direction dir) {
        super(dir);
        this.description = "The door is painted white and accented in gold. Nailed in "
                         + "the center is a gold cross.";
        this.addNameKeys("(?:gold )?cross");
    }
/*----------------------------------------------------------------------------*/
}
