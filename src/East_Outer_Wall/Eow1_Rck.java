package East_Outer_Wall;

import A_Super.Furniture;
import A_Super.Item;
        
public class Eow1_Rck extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Eow1_Rck(Item... items) {
        super(items);
        this.description = "It's a plain weapon rack.";
        this.searchDialog = "You take a look at its contents.";
        this.addNameKeys("rack", "weapon rack");
    }
/*----------------------------------------------------------------------------*/
}
