package Back_Balcony;

import A_Super.Furniture;

public class Bba_Scnc extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bba_Scnc() {
        super();
        this.searchable = false;
        this.description = "It's a copper metal sconce holding a glass bulb. It dimly\n" +
                           "lights the wall with a flickering orange glow.";
        this.actDialog = "Ouch! That's hot!";
        this.addActKeys("touch", "grab", "hold");
        this.addNameKeys("(?:copper )?(?:metal )?(?:sconce|light)");
    }
/*----------------------------------------------------------------------------*/
}
