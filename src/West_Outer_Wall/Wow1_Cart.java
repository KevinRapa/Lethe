package West_Outer_Wall;

import A_Super.Item;
import A_Super.SearchableFurniture;

public class Wow1_Cart extends SearchableFurniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wow1_Cart(Item... items) {
        super(items);
        this.description = "It's a large, wooden cart with a wheel sitting off of\n"
                         + "its axle on the floor.";
        this.searchDialog = "It looks like everything's been removed from this cart.\n";
        this.addNameKeys("(?:large )?(?:wooden )?cart");
    }    
//*----------------------------------------------------------------------------*/
}
