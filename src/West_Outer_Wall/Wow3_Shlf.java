package West_Outer_Wall;

import Super.Furniture;
import Super.Item;
        
public class Wow3_Shlf extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wow3_Shlf(String NAME, Item ... items) {
        super(NAME, items);
        this.description = "A big hefty wooden shelving unit. Now that's what\n"
                         + "you call a shelf!";
        this.searchDialog = "You look among the shelves.";
        this.interactDialog = "This is way too heavy to move. There's not much space\n"
                            + "to move this to anyway.";
        this.addNameKeys("shelf", "wood shelf", "large shelf");
        this.addActKeys("move", "push", "pull");
    }
/*----------------------------------------------------------------------------*/
}
