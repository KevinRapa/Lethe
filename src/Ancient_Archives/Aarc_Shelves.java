package Ancient_Archives;

import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Aarc_Shelves extends Aarc_Furniture {
    //-------------------------------------------------------------------------
    public Aarc_Shelves (Item... items) {
        super(items);
        
        this.description = "The shelves, having once stood holding many volumes, "
                         + "now lie broken all over the floor.";
        this.searchDialog = "You search among the piles of fallen bookshelves.";

        this.addNameKeys("(?:old )?(?:broken )?(?:fallen )?(?:book)?shel(?:f|ves)");
    }
    //-------------------------------------------------------------------------   
}


