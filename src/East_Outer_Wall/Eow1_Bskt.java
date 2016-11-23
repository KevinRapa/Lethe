package East_Outer_Wall;

import Super.Furniture;
import Super.Item;
        
public class Eow1_Bskt extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Eow1_Bskt(String NAME, Item ... items) {
        super(NAME, items);
        this.description = "It's a tall wicker basket.";
        this.searchDialog = "You take a look in the basket.";
        this.addNameKeys("basket", "tall basket");
    }
/*----------------------------------------------------------------------------*/
}
