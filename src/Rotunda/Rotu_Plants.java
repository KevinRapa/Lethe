package Rotunda;

import A_Super.Item;
import A_Super.PottedPlant;

public class Rotu_Plants extends PottedPlant {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rotu_Plants(Item soil) {
        super(soil);

        this.description = "The plants don't seem to be in good shape. They\n"
                         + "droop and some are crowded with weeds.";

        this.addNameKeys("(?:potted )?plants?");
    }
/*----------------------------------------------------------------------------*/
}