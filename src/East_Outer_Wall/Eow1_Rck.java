package East_Outer_Wall;

import Super.Furniture;
import Super.Item;
        
public class Eow1_Rck extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Eow1_Rck(String NAME, Item ... items) {
        super(NAME, items);
        this.description = "It's a plain weapon rack.";
        this.searchDialog = "You take a look at its contents.";
        this.addNameKeys("rack", "weapon rack");
    }
/*----------------------------------------------------------------------------*/
}
