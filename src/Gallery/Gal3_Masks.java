package Gallery;

import A_Super.Furniture;

public class Gal3_Masks extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_Masks() {
        super();
        this.description = "You quickly browse around the masks in the room.\n"
                         + "You find:\t\t\t\t"
                         + "<> A Malian mask\t\t"
                         + "<> A Burkinabe mask\t\t"
                         + "<> A Gabonese mask";
        this.searchDialog = "You aren't sure which one to search first.";
        this.actDialog = "You aren't sure which one to move.";
        this.addActKeys(GETKEYS);
        this.addActKeys("move", "lift", "slide");
        this.addNameKeys("masks?");
/*----------------------------------------------------------------------------*/
    }
}
