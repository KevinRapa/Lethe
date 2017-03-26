package Marble_Hall;

import A_Super.Direction;
import A_Super.Door;

public class Mha3_Door extends Door {
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Mha3_Door (Direction dir) {
        super(dir);
        this.description = "The door to the east is small and arched, made of "
                         + "cheap wood with black iron hinges. It looks as if "
                         + "it hasn't been opened in a very long time. The door "
                         + "to the south is large and heavy.";
    }
/*----------------------------------------------------------------------------*/
}

