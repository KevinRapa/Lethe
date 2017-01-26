package Marble_Hall;

import A_Super.Item;
import A_Super.PottedPlant;

public class Mha_Plant extends PottedPlant { 
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Mha_Plant(Item soil) {
        super(soil);

        this.description = "The potted plant is in good shape. It sits in a\n"
                         + "fancy white vase.";

        this.addNameKeys("(?:potted )?plants?");
    }
/*----------------------------------------------------------------------------*/
}
