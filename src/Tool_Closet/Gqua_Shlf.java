package Tool_Closet;

import Super.Furniture;
import Super.Item;
        
public class Gqua_Shlf extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gqua_Shlf(String NAME, Item ... items) {
        super(NAME, items);
        this.description = "A big hefty wooden shelving unit. Now that's what\n"
                         + "you call a shelf!";
        this.searchDialog = "You look among the shelves.";
        this.interactDialog = "This is way too heavy to move.";
        this.addNameKeys("wooden shelf", "shelf");
        this.addActKeys("move", "push", "pull");
    }
/*----------------------------------------------------------------------------*/
}
