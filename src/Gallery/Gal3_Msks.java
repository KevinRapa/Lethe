package Gallery;

import A_Super.Furniture;

public class Gal3_Msks extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_Msks() {
        super();
        this.searchable = false;
        this.description = "You quickly browse around the masks in the room.\n"
                         + "You find:\n"
                         + "<> A Malian mask\n"
                         + "<> A Burkinabe mask\n"
                         + "<> A Gabonese mask";
        this.searchDialog = "You aren't sure which one to search first.";
        this.actDialog = "You aren't sure which one to move.";
        this.addActKeys("move", "take", "lift", "slide", "remove");
        this.addNameKeys("masks?");
/*----------------------------------------------------------------------------*/
    }
}
