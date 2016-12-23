package Gallery;

import A_Super.Furniture;

public class Gal6_Htch extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal6_Htch() {
        super();
        this.searchable = false;
        this.description = "The hatch leads down into the room below.";
        this.actDialog = "The hatch is open already.";
        this.addActKeys("open");
        this.addNameKeys("hatch");
/*----------------------------------------------------------------------------*/
    }
}
