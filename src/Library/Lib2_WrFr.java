package Library;

import Super.Furniture;
import Super.Item;
        
public class Lib2_WrFr extends Furniture {
    
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib2_WrFr(Item... items) {
        super(items);       
        this.interactDialog = "You push against the shelf, but it doesn't budge.";
        this.description = "The tall bookshelf bears a plaque on the top reading\n"
                         + "\"Warfare\".";
        this.searchDialog = "You peruse its shelves.";
        this.addNameKeys("warfare", "warfare shelf");
        this.addActKeys("push", "move", "rotate", "pull", "slide", "spin");
    }
/*----------------------------------------------------------------------------*/
}
