package Foyer;

import Super.Furniture;

public class Foy_Chnd extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Foy_Chnd(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "It's a huge iron chandelier. Its forged iron frame\n"
                         + "curves intricately. It holds numerous candles; at\n"
                         + "least thirty. You are stunned by its majesty. At the\n"
                         + "same time, you ponder who has the time to maintain\n"
                         + "so many candles.";
        this.searchDialog = "You are pretty sure you can't jump that high.";
        this.addNameKeys("chandelier", "chandeleir");
    }
/*----------------------------------------------------------------------------*/
}
