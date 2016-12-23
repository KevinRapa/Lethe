package Library;

import A_Super.Furniture;
import A_Super.Item;
        
public class Lib4_Prdtn extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib4_Prdtn(Item... items) {
        super(items);
        this.description = "The tall bookshelf bears a plaque on the top reading\n"
                         + "\"Perdition\".";
        this.actDialog = "You push against the shelf, but it doesn't budge.";
        this.searchDialog = "You peruse its shelves.";
        this.addNameKeys("perdition", "perdition shelf");
        this.addActKeys("push", "move", "rotate", "pull", "slide", "spin");
    }
/*----------------------------------------------------------------------------*/
}
