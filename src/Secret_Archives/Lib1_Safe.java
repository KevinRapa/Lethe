package Secret_Archives;

import A_Super.Item;
import A_Super.Safe;

public class Lib1_Safe extends Safe {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib1_Safe(String combo, Item... items) {
        super(combo, items);
        this.description = 
                "The heavy, black, combination safe sits on the floor "
                + "beneath the table.";
    }
//----------------------------------------------------------------------------- 
}
