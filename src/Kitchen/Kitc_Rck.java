package Kitchen;

import Super.Furniture;
import Super.Item;
        
public class Kitc_Rck extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Kitc_Rck(Item... items) {
        super(items);
        this.description = "It's a rack of hooks used to hold keys.";
        this.searchDialog = "Here's what the hooks hold:";
        this.addNameKeys("rack", "key rack");
    }
/*----------------------------------------------------------------------------*/
}
