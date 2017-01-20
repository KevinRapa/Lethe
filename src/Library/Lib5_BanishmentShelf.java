package Library;

import A_Super.Furniture;
import A_Super.Item;
        
public class Lib5_BanishmentShelf extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib5_BanishmentShelf(Item... items) {
        super(items);
        this.description = "The tall bookshelf bears a plaque on the top reading\n"
                         + "\"Banishment\".";
        this.actDialog = "You push against the shelf, but it doesn't budge.";
        this.searchDialog = "You peruse its shelves.";
        this.addNameKeys("banishment", "(?:south )?(?:book)?shelf");
        this.addActKeys("push", "move", "rotate", "pull", "slide", "spin");
    }
/*----------------------------------------------------------------------------*/
}

