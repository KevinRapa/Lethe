package West_Outer_Wall;

import A_Super.Furniture;
import A_Super.Item;

public class Wow1_Shelves extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wow1_Shelves(Item... items) {
        super(items);
        this.description = "The shelves are stocked with many chemicals and\n"
                         + "tools.";
        this.searchDialog = "You look on the shelves.";
        this.addNameKeys("shelf", "shelves", "jars", "(?:cleaning )?tools", "brushes", "liquids");
    }
/*----------------------------------------------------------------------------*/        
}
