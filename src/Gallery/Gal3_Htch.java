package Gallery;

import A_Super.Furniture;

public class Gal3_Htch extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_Htch() {
        super();
        this.searchable = false;
        this.description = "The hatch leads upwards into another room.";
        this.actDialog = "The hatch is open already.";
        this.addNameKeys("hatch");
        this.addActKeys("open");
/*----------------------------------------------------------------------------*/
    }
}
