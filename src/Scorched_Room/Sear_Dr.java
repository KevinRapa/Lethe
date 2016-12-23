package Scorched_Room;

import A_Super.Door;

public class Sear_Dr extends Door {
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Sear_Dr () {
        super();
        this.description = "The door is in even worse condition from this side.\n"
                         + "Whoever it is lying there was hitting it very\n"
                         + "forcefully with that crowbar to break it down.";
        this.actDialog = "There's enough evidence here to suggest you can't go\n"
                    + "through there.";
    }
}
