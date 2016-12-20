package Gallery;

import Super.Furniture;

public class Gal3_Arts extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_Arts() {
        super();
        this.searchable = false;
        this.description = "You quickly browse around the masks in the room.\n"
                         + "You find:\n"
                         + "<> A Zambian statuette\n"
                         + "<> A deformed statue\n"
                         + "<> A Nigerian trinket";
        this.searchDialog = "You aren't sure which one to search first.";
/*----------------------------------------------------------------------------*/
    }
}
