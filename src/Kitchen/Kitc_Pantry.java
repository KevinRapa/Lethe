package Kitchen;

import A_Super.Item;
import A_Super.Openable;
import A_Super.SearchableFurniture;
        
public class Kitc_Pantry extends SearchableFurniture implements Openable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Kitc_Pantry(Item... items) {
        super(items);
        this.description = "From the pantry emits a disgusting odor!";
        this.searchDialog = "The pantry creaks as you slowly open it.";
        
        this.addNameKeys("pantry");
    }
/*----------------------------------------------------------------------------*/
}
