package Gallery;

import Super.Furniture;

public class Gal1_Sclptrs extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Sclptrs(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "You quickly browse around the sculptures in the room.\n"
                         + "You find:\n"
                         + "<> A dragon\n"
                         + "<> A screen\n"
                         + "<> Some armor\n";
        this.searchDialog = "You aren't sure which one to search first.";
        this.addNameKeys("sculptures", "sculpture");
/*----------------------------------------------------------------------------*/
    }
}
