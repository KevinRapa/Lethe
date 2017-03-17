package Marble_Hall;

import A_Super.Item;
import A_Super.PottedPlant;

public class Mha_Plant extends PottedPlant { 
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Mha_Plant(Item soil, Item gift) {
        super(soil, gift);

        this.description = "The potted plant is in okay shape, but could afford a bit more care. "
                + "It sits in a fancy white vase.";
    }
/*----------------------------------------------------------------------------*/
}
