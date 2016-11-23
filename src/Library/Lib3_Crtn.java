package Library;

import Super.Furniture;
import Super.Item;
        
public class Lib3_Crtn extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib3_Crtn(String NAME, Item ... items) {
        super(NAME, items);
        this.description = "The tall bookshelf bears a plaque on the top reading\n"
                         + "\"Creation\".";
        this.interactDialog = "You push against the shelf, but it doesn't budge.";
        this.searchDialog = "You peruse its shelves.";
        this.addNameKeys("creation", "creation shelf");
        this.addActKeys("push", "move", "rotate", "pull", "slide", "spin");
    }
/*----------------------------------------------------------------------------*/
}
