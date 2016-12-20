package Vestibule;

import Super.Furniture;

public class Vest_Tpstr extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Vest_Tpstr() {
        super();
        this.searchable = false;
        this.description = "A large, medieval-era tapestry. It appears to\n" +
                           "depict an impoverished man offering a glowing\n" +
                           "object to a king in a throne. The king appears\n" +
                           "curiously frail and famished.";
        this.searchDialog = "You peek behind the heavy tapestry\n" +
                            "and find a blank wall.";
        this.addNameKeys("tapestry", "large tapestry");
/*----------------------------------------------------------------------------*/
    }
}
