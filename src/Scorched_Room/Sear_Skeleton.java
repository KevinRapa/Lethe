package Scorched_Room;

import static A_Main.NameConstants.CROWBAR;
import A_Super.Item;
import A_Super.SearchableFurniture;
/**
 * Holds a crowbar, to pry the panel in the ransacked room.
 * 
 * @see Ransacked_Quarters.Rqua_Panel
 * @author Kevin Rapa
 */  
public class Sear_Skeleton extends SearchableFurniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Sear_Skeleton(Item... items) {
        super(items);
        this.description = "The scorched body lies against the boarded up door.";
        this.searchDialog = "You crouch down.";
        this.addNameKeys("skeleton", "(?:scorched )?body");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (this.containsItem(CROWBAR))
            return this.description.concat(" There's a crowbar in its hand.");
        else
            return this.description;
    }
/*----------------------------------------------------------------------------*/
}
