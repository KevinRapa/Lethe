package Study;

import Super.Item;
import Super.Safe;

public class Stud_Safe extends Safe {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Stud_Safe(String combo, Item... items) {
        super(combo, items);
        this.description = "It's a black metal safe hidden in the wall!";
    }
/*----------------------------------------------------------------------------*/ 
}
