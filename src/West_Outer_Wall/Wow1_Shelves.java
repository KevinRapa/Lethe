package West_Outer_Wall;

import A_Super.Item;
import A_Super.SearchableFurniture;

public class Wow1_Shelves extends SearchableFurniture {
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
