package Back_Balcony;

import A_Super.Furniture;

public class Bba_Sconce extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bba_Sconce() {
        super();
        this.description = "It's a copper metal sconce holding a glass bulb. It dimly\n" +
                           "lights the wall with a flickering orange glow.";
        this.actDialog = "Ouch! That's hot!";
        this.addActKeys("touch", "grab", "hold");
        this.addNameKeys("(?:copper )?(?:metal )?(?:sconce|light)");
    }
/*----------------------------------------------------------------------------*/
}
