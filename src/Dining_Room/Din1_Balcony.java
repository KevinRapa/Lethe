package Dining_Room;

import A_Super.Balcony;

public class Din1_Balcony extends Balcony {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Din1_Balcony() {
        super();

        this.description = "The second-floor balcony bows out into the room. Up "
                         + "on the south wall, you see the source of the noise.";

        this.addNameKeys("(?:second[- ]floor )?balcony(?: railing)?");
    }
//-----------------------------------------------------------------------------
}
