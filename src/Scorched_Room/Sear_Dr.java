package Scorched_Room;

import A_Super.Furniture;

public class Sear_Dr extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Sear_Dr () {
        super();
        this.searchable = false;
        this.description = "The door is in even worse condition from this side.\n"
                         + "Whoever it is lying there was hitting it very\n"
                         + "forcefully with that crowbar to break it down.";
        this.actDialog = "There's enough evidence here to suggest you can't go\n"
                       + "through there.";
        this.addNameKeys("west door", "door");
        this.addActKeys("open", "use");
    }
/*----------------------------------------------------------------------------*/
}
