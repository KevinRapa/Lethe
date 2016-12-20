package Kitchen;

import Super.Furniture;
import Super.Item;
        
public class Kitc_Brls extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Kitc_Brls(Item... items) {
        super(items);
        this.description = "The two barrels are open and filled with stale\n"
                         + "barley and rye.";
        this.searchDialog = "You look into the barrels.";
        this.interactDialog = "This is way too heavy to move.";
        this.addActKeys("move", "push", "pull");
        this.addNameKeys("barrel", "barrels");
    }
/*----------------------------------------------------------------------------*/
}
