package Library;

import A_Super.Furniture;

public class Lib5_Cndlbr extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib5_Cndlbr() {
        super();
        this.searchable = false;
        this.description = "The intricate iron candelabra sits in the corner\n"
                         + "holding 5 candles.";
        this.actDialog = "Ouch! That's hot! Why do you do this?";
        this.addNameKeys("(?:intricate )?(?:iron )?(?:standing )?candelabra");
        this.addActKeys("touch", "hold", "grab");
    }
/*----------------------------------------------------------------------------*/
}

