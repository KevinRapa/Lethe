package Secret_Archives;

import A_Super.Item;
import A_Super.Safe;

public class Lib1_Safe extends Safe {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib1_Safe(String combo, Item... items) {
        super(combo, items);
        this.description = "The black safe sits on the floor. Something is "
                         + "carved on its surface. It says... \"u wrote "
                         + "the code in your notes. remember?\"";
    }
/*----------------------------------------------------------------------------*/ 
}
