package Study;

import Super.Furniture;
import Super.Item;
        
public class Stud_BkCs extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Stud_BkCs(Item... items) {
        super(items);
        this.description = "It's a small square bookcase with a stone head\n"
                         + "sculpture on top.";
        this.searchDialog = "You peruse its shelves.";
        this.addNameKeys("bookcase", "bookshelf", "books");
    }
/*----------------------------------------------------------------------------*/
}
