package Library;

import A_Super.Item;
import A_Super.SearchableFurniture;
        
public class Lib3_CreationShelf extends SearchableFurniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib3_CreationShelf(Item... items) {
        super(items);
        this.description = "The tall bookshelf bears a plaque on the top reading\n"
                         + "\"Creation\".";
        this.actDialog = "You push against the shelf, but it doesn't budge.";
        this.searchDialog = "You peruse its shelves.";
        this.addNameKeys("creation", "(?:south )?(?:book)?shelf");
        this.addActKeys(MOVEPATTERN);
    }
/*----------------------------------------------------------------------------*/
}
