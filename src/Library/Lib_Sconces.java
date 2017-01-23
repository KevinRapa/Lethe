package Library;

import A_Super.Furniture;

public class Lib_Sconces extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib_Sconces() {
        super();

        this.description = "Copper metal sconces holding glass bulbs. They dimly\n" +
                           "light the wall with a flickering orange glow.";
        this.actDialog = "Ouch! That's hot!";
        this.addNameKeys("(?:electric )?(?:copper )?(?:metal )?(?:sconces?|lights?)");
        this.addActKeys("grab", "hold", "touch");
    }
/*----------------------------------------------------------------------------*/
}

