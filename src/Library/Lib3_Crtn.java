package Library;

import A_Super.Furniture;
import A_Super.Item;
        
public class Lib3_Crtn extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib3_Crtn(Item... items) {
        super(items);
        this.description = "The tall bookshelf bears a plaque on the top reading\n"
                         + "\"Creation\".";
        this.actDialog = "You push against the shelf, but it doesn't budge.";
        this.searchDialog = "You peruse its shelves.";
        this.addNameKeys("creation", "creation shelf");
        this.addActKeys("push", "move", "rotate", "pull", "slide", "spin");
    }
/*----------------------------------------------------------------------------*/
}
