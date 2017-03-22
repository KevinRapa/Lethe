package Scorched_Room;

import static A_Main.Names.CROWBAR;
import A_Super.Item;
import A_Super.Skeleton;
/**
 * Holds a crowbar, to pry the panel in the ransacked room.
 * 
 * @see Ransacked_Quarters.Rqua_Panel
 * @author Kevin Rapa
 */  
public class Sear_Skeleton extends Skeleton {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Sear_Skeleton(Item... items) {
        super(items);
        this.description = "The scorched body lies against the boarded up door.";
        this.addNameKeys("(?:scorched )?body");
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
