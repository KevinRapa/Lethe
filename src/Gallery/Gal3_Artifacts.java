package Gallery;

import A_Super.Furniture;

public class Gal3_Artifacts extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_Artifacts() {
        super();

        this.description = "You quickly browse around the artifacts in the room.\n"
                         + "You find:\t\t\t"
                         + "<> A Zambian statuette\t\t"
                         + "<> A deformed statue\t\t"
                         + "<> A Nigerian trinket";
        this.searchDialog = "You aren't sure which one to search first.";
        this.addNameKeys("artifacts?", "statues?");
/*----------------------------------------------------------------------------*/
    }
}
