package Dining_Room;

import A_Super.Door;
import A_Super.Direction;

public class Din1_Door extends Door {
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Din1_Door (Direction dir) {
        super(dir);
        this.description = "The backside of the door to this room looks as\n"
                         + "complicated as you imagined. Many plates, hinges,\n"
                         + "and springs cover its back.";
    }
/*----------------------------------------------------------------------------*/
}
