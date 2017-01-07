package Catacombs;

import A_Super.Direction;
import A_Super.Door;

public class Ct_Dr extends Door {
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Ct_Dr(Direction dir) {
        super(dir);
        this.description = "The door is ramshackle, held together with old dark boards\n"
                         + "nailed together and a rusty handle.";
        this.addNameKeys("(?:ancient |old |ramshackle )?(?:wooden )?(?:boarded )?door");
    }
/*----------------------------------------------------------------------------*/
}
