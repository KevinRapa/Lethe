package Rotunda;

import A_Super.Direction;
import A_Super.Door;

public class Rotu_Door extends Door {
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Rotu_Door (Direction dir) {
        super(dir);
        this.description = "A heavy wooden door. It's surrounded at the edge by\n"
                         + "a seam, as if separate from the rest of the room. Very\n"
                         + "peculiar.";
    }
/*----------------------------------------------------------------------------*/
}
