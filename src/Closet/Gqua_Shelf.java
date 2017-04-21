package Closet;

import A_Super.Item;
import A_Super.SearchableFurniture;
import A_Super.Unmoveable;
        
public class Gqua_Shelf extends SearchableFurniture implements Unmoveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gqua_Shelf(Item... items) {
        super(items);
        this.description = "A big hefty wooden shelving unit. Now that's what "
                         + "you call a shelf!";
        this.searchDialog = "You look among the shelves.";
        this.actDialog = "You give the big wooden shelf a jostle, but it shelf stands firmly in place letting off only a thick *knock*.";
        
        this.addNameKeys("(?:big )?(?:hefty )?(?:wooden )?(?:shelf|shelving unit)");
        this.addActKeys(JOSTLEPATTERN);
    }
//-----------------------------------------------------------------------------
    @Override public String interact(String key) {
        if (key.matches(JOSTLEPATTERN))
            return "You give it a kick. 'Wow, how sturdy! Truly a mark of artisan craftsmanship.'";
        else
            return DEFAULT_USE;
    }
//-----------------------------------------------------------------------------
}
