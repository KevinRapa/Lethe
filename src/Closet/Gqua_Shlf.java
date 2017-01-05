package Closet;

import A_Super.Furniture;
import A_Super.Item;
        
public class Gqua_Shlf extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gqua_Shlf(Item... items) {
        super(items);
        this.description = "A big hefty wooden shelving unit. Now that's what\n"
                         + "you call a shelf!";
        this.searchDialog = "You look among the shelves.";
        this.actDialog = "This is way too heavy to move.";
        this.addNameKeys("(?:big )?(?:hefty )?(?:wooden )?(?:shelf|shelving unit)");
        this.addActKeys("move", "push", "pull");
    }
/*----------------------------------------------------------------------------*/
}
