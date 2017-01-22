package Observatory;

import A_Super.Furniture;
import A_Super.Item;
/**
 * Holds a book which helps with the observatory puzzle.
 * 
 * @see Observatory.Obs2_Book
 * @author Kevin Rapa
 */
public class Obs2_BkShlf extends Furniture {
    // ========================================================================
    public Obs2_BkShlf (Item... items) {
        super(items);
        
        this.description = "The tall dark brown bookshelf rests on small curved feet.";
        this.searchDialog = "You look on the shelves.";

        this.addNameKeys("(?:tall )?(?:brown )?(?:shelf|bookshelf)", "books");
    }
    // ========================================================================     
}


