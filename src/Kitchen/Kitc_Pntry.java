package Kitchen;

import A_Super.Container;
import A_Super.Furniture;
import A_Super.Item;
        
public class Kitc_Pntry extends Furniture implements Container {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Kitc_Pntry(Item... items) {
        super(items);
        this.description = "From the pantry emits a disgusting odor!";
        this.searchDialog = "The pantry creaks as you slowly open it.";
        
        this.addNameKeys("pantry");
    }
/*----------------------------------------------------------------------------*/
}
