package Library;

import Super.Furniture;

public class Lib5_Cndlbr extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib5_Cndlbr(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "The intricate iron candelabra sits in the corner\n"
                         + "holding 5 candles.";
        this.interactDialog = "Ouch! That's hot! Why do you do this?";
        this.addNameKeys("candelabra", "standing candelabra");
        this.addActKeys("touch", "hold", "grab");
    }
/*----------------------------------------------------------------------------*/
}

