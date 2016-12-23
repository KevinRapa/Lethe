package Closet;

import A_Super.Furniture;
import A_Super.Item;
        
public class Gqua_Skltn extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gqua_Skltn(String NAME, Item ... items) {
        super(items);
        this.description = "The body lies face down on the floor.";
        this.searchDialog = "You crouch down.";
        this.addNameKeys("skeleton");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description;
        
        if (this.doesThisHaveIt("crowbar")) {
            rep += " There's a\ncrowbar in its hand.";
        }
        
        return rep;
    }
}
