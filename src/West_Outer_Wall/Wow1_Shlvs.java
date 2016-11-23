package West_Outer_Wall;

import Super.Furniture;
import Super.Item;

public class Wow1_Shlvs extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wow1_Shlvs(String NAME, Item ... items) {
        super(NAME, items);
        this.description = "The shelves are stocked with many chemicals and\n"
                         + "tools.";
        this.searchDialog = "You look on the shelves.";
        this.addNameKeys("shelf", "shelves");
    }
/*----------------------------------------------------------------------------*/        
}
