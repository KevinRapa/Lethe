package West_Outer_Wall;

import Super.Furniture;
import Super.Item;

public class Wow1_Crt extends Furniture{
    
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wow1_Crt(String NAME, Item ... items) {
        super(NAME, items);
        this.description = "It's a large, wooden cart with a wheel sitting off of\n"
                         + "its axle on the floor.";
        this.searchDialog = "It looks like everything's been removed from this cart.\n";
        this.addNameKeys("cart");
    }    
//*----------------------------------------------------------------------------*/
}
