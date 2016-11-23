package Tool_Closet;

import Super.Furniture;
import Super.Item;
        
public class Gqua_Wrkbnch extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gqua_Wrkbnch(String NAME, Item ... items) {
        super(NAME, items);
        this.description = "It's a poplar table with stuff on it.";
        this.searchDialog = "You look through its various drawers and nooks.";
        this.interactDialog = "This is way too heavy to move.";
        this.addNameKeys("workbench");
        this.addActKeys("move", "push", "pull");
    }
/*----------------------------------------------------------------------------*/
}