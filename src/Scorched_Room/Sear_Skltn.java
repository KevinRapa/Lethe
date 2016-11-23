package Scorched_Room;

import Super.Furniture;
import Super.Item;
        
public class Sear_Skltn extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Sear_Skltn(String NAME, Item ... items) {
        super(NAME, items);
        this.description = "The scorched body lies against the boarded up door.";
        this.searchDialog = "You crouch down.";
        this.addNameKeys("skeleton");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description;
        
        if (this.doesThisHaveIt("crowbar")) {
            rep += "\nThere's a crowbar in its hand.";
        }       
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
