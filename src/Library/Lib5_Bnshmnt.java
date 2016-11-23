package Library;

import Super.Furniture;
import Super.Item;
        
public class Lib5_Bnshmnt extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib5_Bnshmnt(String NAME, Item ... items) {
        super(NAME, items);
        this.description = "The tall bookshelf bears a plaque on the top reading\n"
                         + "\"Banishment\".";
        this.interactDialog = "You push against the shelf, but it doesn't budge.";
        this.searchDialog = "You peruse its shelves.";
        this.addNameKeys("banishment", "banishment shelf");
        this.addActKeys("push", "move", "rotate", "pull", "slide", "spin");
    }
/*----------------------------------------------------------------------------*/
}

