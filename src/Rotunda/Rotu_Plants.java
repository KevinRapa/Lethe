package Rotunda;

import A_Super.Item;
import A_Super.PottedPlant;

public class Rotu_Plants extends PottedPlant {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rotu_Plants(Item soil, Item gift) {
        super(soil, gift);

        this.description = "The plants don't seem to be in good shape. They "
                         + "droop and some are crowded with weeds.";
    }
//-----------------------------------------------------------------------------
}