package West_Outer_Wall;

import A_Super.Item;
import A_Super.SearchableFurniture;
        
public class Wow3_Shelf extends SearchableFurniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wow3_Shelf(Item... items) {
        super(items);
        this.description = "A big hefty wooden shelving unit. Now that's what "
                         + "you call a shelf!";
        this.searchDialog = "You look among the shelves.";
        this.actDialog = "This is way too heavy to move. There's not much space "
                            + "to move this to anyway.";
        this.addNameKeys("(?:large )?(?:wood )?shelf");
        this.addActKeys("move", "push", "pull");
    }
//-----------------------------------------------------------------------------
}
