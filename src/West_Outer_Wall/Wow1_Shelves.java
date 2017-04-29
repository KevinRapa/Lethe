package West_Outer_Wall;

import A_Super.Item;
import A_Super.SearchableFurniture;
import A_Super.Unmoveable;

public class Wow1_Shelves extends SearchableFurniture implements Unmoveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wow1_Shelves(Item... items) {
        super(items);
        this.description = "The shelves are stocked with many chemicals and tools.";
        this.searchDialog = "You look on the shelves.";
        this.actDialog = "So many tools! You are overwhelmed with choice, "
                + "while lightly dabbing some sweat off your forehead.";
        
        this.addActKeys(GETPATTERN);
        this.addNameKeys("shelf|shelves|jars|(?:cleaning )?tools|brushes|liquids");
    }
//-----------------------------------------------------------------------------        
}
