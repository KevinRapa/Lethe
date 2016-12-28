package West_Outer_Wall;

import A_Super.Furniture;
import A_Super.Item;
        
public class Wow3_Shlf extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wow3_Shlf(Item... items) {
        super(items);
        this.description = "A big hefty wooden shelving unit. Now that's what\n"
                         + "you call a shelf!";
        this.searchDialog = "You look among the shelves.";
        this.actDialog = "This is way too heavy to move. There's not much space\n"
                            + "to move this to anyway.";
        this.addNameKeys("(?:large )?(?:wood )?shelf");
        this.addActKeys("move", "push", "pull");
    }
/*----------------------------------------------------------------------------*/
}
