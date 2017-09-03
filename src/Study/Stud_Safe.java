package Study;

import A_Super.Item;
import A_Super.Safe;
/**
 * Holds the first phylactery, a book.
 * 
 * @see Study.Stud_BookPhylactery
 * @see A_Super.Safe
 * @author Kevin Rapa
 */
public class Stud_Safe extends Safe {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Stud_Safe(int combo, Item... items) {
        super(combo, items);
        this.description = "It's a black metal safe hidden in the wall!";
    }
//----------------------------------------------------------------------------- 
}
