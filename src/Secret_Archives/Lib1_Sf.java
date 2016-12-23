package Secret_Archives;

import A_Super.Item;
import A_Super.Safe;

public class Lib1_Sf extends Safe {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib1_Sf(String combo, Item... items) {
        super(combo, items);
        this.description = "The black safe sits on the floor. Something is\n"
                         + "carved on its surface. It says... \"u wrote\n"
                         + "the code in your notes. remember?\"";
    }
/*----------------------------------------------------------------------------*/ 
}
