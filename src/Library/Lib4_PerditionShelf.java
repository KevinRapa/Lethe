package Library;

import A_Super.Item;
import A_Super.SearchableFurniture;
        
public class Lib4_PerditionShelf extends SearchableFurniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib4_PerditionShelf(Item... items) {
        super(items);
        this.description = "The tall bookshelf bears a plaque on the top reading\n"
                         + "\"Perdition\".";
        this.actDialog = "You push against the shelf, but it doesn't budge.";
        this.searchDialog = "You peruse its shelves.";
        this.addNameKeys("perdition", "(?:west )?(?:book)?shelf");
        this.addActKeys(MOVEPATTERN);
    }
/*----------------------------------------------------------------------------*/
}
