package Kitchen;

import Super.Furniture;
import Super.Item;
        
public class Kitc_Pntry extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Kitc_Pntry(String NAME, Item ... items) {
        super(NAME, items);
        this.description = "From the pantry emits a disgusting odor!";
        this.searchDialog = "The pantry creaks as you slowly open it.";
        this.interactDialog = "The pantry is unlocked. Maybe you should search it?";
        this.addActKeys("open");
        this.addNameKeys("pantry");
    }
/*----------------------------------------------------------------------------*/
}
