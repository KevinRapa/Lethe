package Vestibule;

import A_Super.Wall_Art;

public class Vest_Tpstr extends Wall_Art {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Vest_Tpstr() {
        super();
        this.description = "A large, medieval-era tapestry. It appears to\n" +
                           "depict an impoverished man offering a glowing\n" +
                           "object to a king in a throne. The king appears\n" +
                           "curiously frail and famished.";
        this.addNameKeys("(?:large )?tapestry");
    }
/*----------------------------------------------------------------------------*/    
}
