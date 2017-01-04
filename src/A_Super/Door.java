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
        this.actDialog = "none";

        this.addActKeys("open", "use", "close");
        this.addNameKeys(dir + " door", "door");
    }
/*----------------------------------------------------------------------------*/    
    @Override public String interact(String key) {
        if (key.matches("close"))
            return "The door is already closed.";
        else {
            Player.move(DIR);
            return this.actDialog;
        }
    } 
/*----------------------------------------------------------------------------*/ 
}
