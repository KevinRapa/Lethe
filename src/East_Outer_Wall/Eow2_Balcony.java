package East_Outer_Wall;

import A_Super.Balcony;

public class Eow2_Balcony extends Balcony {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Eow2_Balcony() {
        super();

        this.description = "The second-floor balcony follows the north wall to "
                         + "the west and ends at a door.";

        this.addNameKeys("(?:small )?(?:second[- ]floor )?balcony");
    }
/*----------------------------------------------------------------------------*/
}
