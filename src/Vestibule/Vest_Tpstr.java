package Vestibule;

import A_Super.WallArt;

public class Vest_Tpstr extends WallArt {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Vest_Tpstr() {
        super();
        this.description = "A large, medieval-era tapestry. It appears to " +
                           "depict an impoverished man offering a glowing " +
                           "object to a king in a throne. The king appears " +
                           "curiously frail and famished.";
        this.addNameKeys("(?:large )?(?:medieval-era )?tapestry");
    }
//-----------------------------------------------------------------------------    
}
