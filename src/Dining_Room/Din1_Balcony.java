package Dining_Room;

import A_Super.Furniture;

public class Din1_Balcony extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Din1_Balcony() {
        super();

        this.description = "The second-floor balcony bows out into the room. Up\n"
                         + "on the south wall, you see the source of the noise.";
        this.searchDialog = "You will have to go up there to do that.";
        this.addNameKeys("(?:second[- ]floor )?balcony(?: railing)?", "railing", "banister");
    }
/*----------------------------------------------------------------------------*/
}
