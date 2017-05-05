package Dining_Room;

import A_Super.Chandelier;

public class Din1_Chandelier extends Chandelier {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Din1_Chandelier() {
        super();

        this.useDialog = "The chandlier is too high up.";
        this.description = 
                "The chandelier shimmers in the moonlight. Its candles " +
                "are unlit, which at this point seems odd to you. Still, "
              + "the room is well lit from the light shining in.";
    }
//-----------------------------------------------------------------------------
}