package Kitchen;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.Openable;
        
public class Kitc_Pntry extends Furniture implements Openable {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Kitc_Pntry(Item... items) {
        super(items);
        this.description = "From the pantry emits a disgusting odor!";
        this.searchDialog = "The pantry creaks as you slowly open it.";
        
        this.addNameKeys("pantry");
    }
/*----------------------------------------------------------------------------*/
}
