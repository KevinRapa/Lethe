package Dining_Room;

import A_Super.Furniture;

public class Din1_Chandelier extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Din1_Chandelier() {
        super();
        this.searchable = false;
        this.description = "The chandelier shimmers in the moonlight. Its candles\n" +
                           "are unlit, which at this point seems odd to you. Still,\n"
                         + "the room is well lit from the light shining in.";
        this.searchDialog = "You are pretty sure you can't jump that high.";
        this.addNameKeys("chandelier|light");
    }
/*----------------------------------------------------------------------------*/
}