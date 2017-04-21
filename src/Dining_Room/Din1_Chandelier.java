package Dining_Room;

import A_Super.Furniture;

public class Din1_Chandelier extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Din1_Chandelier() {
        super();

        this.description = "The chandelier shimmers in the moonlight. Its candles " +
                           "are unlit, which at this point seems odd to you. Still, "
                         + "the room is well lit from the light shining in.";
        this.searchDialog = "You are pretty sure you can't jump that high.";
        this.actDialog = "Swinging from it doesn't seem like a productive thing to do.";
        
        this.addActKeys("hang", "swing");
        this.addNameKeys("chandelier|light");
    }
//-----------------------------------------------------------------------------
}