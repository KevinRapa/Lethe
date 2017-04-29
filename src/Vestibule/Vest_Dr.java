package Vestibule;

import A_Super.Direction;
import A_Super.Door;

public class Vest_Dr extends Door {
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Vest_Dr (Direction dir) {
        super(dir);
        this.description = "A heavy wooden door. There seems to be a lot "
                         + "more mechanical works to this door than is typical.";
    }
//-----------------------------------------------------------------------------
}
