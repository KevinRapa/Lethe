package Library;

import A_Super.Item;
import A_Super.SearchableFurniture;
        
public class Lib5_BanishmentShelf extends SearchableFurniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib5_BanishmentShelf(Item... items) {
        super(items);
        this.description = "The tall bookshelf bears a plaque on the top reading "
                         + "\"Banishment\".";
        this.actDialog = "You push against the shelf, but it doesn't budge.";
        this.searchDialog = "You peruse its shelves.";
        this.addNameKeys("banishment", "(?:south )?(?:book)?shelf");
        this.addActKeys(MOVEPATTERN);
    }
/*----------------------------------------------------------------------------*/
}

