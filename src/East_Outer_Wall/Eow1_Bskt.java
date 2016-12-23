package East_Outer_Wall;

import A_Super.Furniture;
import A_Super.Item;
        
public class Eow1_Bskt extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Eow1_Bskt(Item... items) {
        super(items);
        this.description = "It's a tall wicker basket.";
        this.searchDialog = "You take a look in the basket.";
        this.addNameKeys("basket", "tall basket");
    }
/*----------------------------------------------------------------------------*/
}
