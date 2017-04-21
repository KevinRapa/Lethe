package Kitchen;

import A_Super.Item;
import A_Super.Moveable;
import A_Super.Openable;
import A_Super.SearchableFurniture;
        
public class Kitc_Pantry extends SearchableFurniture implements Openable, Moveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Kitc_Pantry(Item... items) {
        super(items);
        this.description = "A disgusting odor seeps out of the tall pantry.";
        this.searchDialog = "The pantry creaks as you slowly open it.";
        
        this.addNameKeys("(?:tall )?pantry");
    }
//-----------------------------------------------------------------------------
}
