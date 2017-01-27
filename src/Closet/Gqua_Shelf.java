package Closet;

import A_Super.Item;
import A_Super.SearchableFurniture;
        
public class Gqua_Shelf extends SearchableFurniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gqua_Shelf(Item... items) {
        super(items);
        this.description = "A big hefty wooden shelving unit. Now that's what\n"
                         + "you call a shelf!";
        this.searchDialog = "You look among the shelves.";
        this.actDialog = "This is way too heavy to move.";
        
        this.addNameKeys("(?:big )?(?:hefty )?(?:wooden )?(?:shelf|shelving unit)");
        this.addActKeys(JOSTLEPATTERN);
        this.addActKeys("move", "push", "pull");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        if (key.matches(JOSTLEPATTERN))
            return "You give it a kick. 'Wow, how sturdy! Truly a mark of artisan craftsmanship.'";
        else
            return DEFAULT_USE;
    }
/*----------------------------------------------------------------------------*/
}
