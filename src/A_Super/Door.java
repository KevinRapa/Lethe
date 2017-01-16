package A_Super;

import A_Main.Player;

public class Door extends Furniture {
    protected final Direction DIR; 
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Door (Direction dir) {
        super();
        this.searchable = false;
        this.DIR = dir;
        this.searchDialog = "You aren't sure what you'd search for on a door.";
        this.description = "It looks like a heavy wooden door.";
        this.actDialog = null;

        this.addActKeys("open", "use", "close", "kick");
        this.addNameKeys(dir + " door", "door", "(?:heavy )?(?:wooden )?door");
    }
/*----------------------------------------------------------------------------*/    
    @Override public String interact(String key) {
        if (key.matches("close"))
            return "The door is already closed.";
        else if (key.matches("kick"))
            return "You thrust your boot into the door, but the door is too\n" +
                   "well-built to give.";
        else {
            Player.move(DIR);
            return this.actDialog;
        }
    } 
/*----------------------------------------------------------------------------*/ 
}
