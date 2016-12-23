package Closet;

import A_Super.Container;
import A_Super.Furniture;
import A_Super.Item;
        
public class Gqua_Wrkbnch extends Furniture implements Container {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gqua_Wrkbnch(Item... items) {
        super(items);
        this.description = "It's a poplar table with stuff on it.";
        this.searchDialog = "You look through its various drawers and nooks.";
        this.actDialog = "This is way too heavy to move.";
        this.addNameKeys("workbench");
        this.addActKeys("move", "push", "pull");
    }
/*----------------------------------------------------------------------------*/
}