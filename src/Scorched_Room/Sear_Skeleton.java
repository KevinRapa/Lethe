package Scorched_Room;

import static A_Main.NameConstants.CROWBAR;
import A_Super.Item;
import A_Super.Moveable;
import A_Super.SearchableFurniture;
/**
 * Holds a crowbar, to pry the panel in the ransacked room.
 * 
 * @see Ransacked_Quarters.Rqua_Panel
 * @author Kevin Rapa
 */  
public class Sear_Skeleton extends SearchableFurniture implements Moveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Sear_Skeleton(Item... items) {
        super(items);
        this.description = "The scorched body lies against the boarded up door.";
        this.searchDialog = "You crouch down.";
        this.actDialog = "\"Hello? Are you okay? Do you know a way out?\" You repeatedly ask the skeleton.\n"
                       + "The skeleton lies silently, motionless, rudely ignoring your inquiry.";
        this.addActKeys("eat", "speak|talk|converse|chat|greet|listen");
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
    @Override public String interact(String key) {
        if (key.equals("eat"))
            return "The thought of that makes you shutter...";
        else
            return this.actDialog;
    }
/*----------------------------------------------------------------------------*/
    @Override public String moveIt() {
        return "This skeleton is most likely dead at this point. May as well let it rest.";
    }
/*----------------------------------------------------------------------------*/
}
