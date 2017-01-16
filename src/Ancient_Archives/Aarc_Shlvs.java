package Ancient_Archives;

import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Aarc_Shlvs extends Aarc_Furniture {
    // ========================================================================
    public Aarc_Shlvs (Item... items) {
        super(items);
        
        this.description = "The shelves, having once stood holding many volumes,\n"
                         + "now lie broken all over the floor.";
        this.searchDialog = "You search among the piles of fallen bookshelves.";

        this.addNameKeys("(?:old )?(?:broken )?(?:fallen )?(?:book)?shel(?:f|ves)");
    }
    // ========================================================================   
}


