package Kitchen;

import A_Super.Furniture;
import A_Super.Item;
        
public class Kitc_Rck extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Kitc_Rck(Item... items) {
        super(items);
        this.description = "It's a rack of hooks used to hold keys.";
        this.searchDialog = "You look among the hooks.";
        this.addNameKeys("rack", "key rack");
    }
/*----------------------------------------------------------------------------*/
}
