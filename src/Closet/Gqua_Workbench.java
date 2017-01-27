package Closet;

import A_Super.Item;
import A_Super.Openable;
import A_Super.SearchableFurniture;
/**
 * Contains a screw, for constructing the red lens.
 * 
 * @see Closet.Scrw
 * @see Gallery.LghtMchn
 * @author Kevin Rapa
 */        
public class Gqua_Workbench extends SearchableFurniture implements Openable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gqua_Workbench(Item... items) {
        super(items);
        this.description = "It's a poplar table with stuff on it.";
        this.searchDialog = "You look through its various drawers and nooks.";
        this.actDialog = "This is way too heavy to move.";
        
        this.addNameKeys("(?:poplar |wood(?:en)? )?(?:table|workbench)");
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