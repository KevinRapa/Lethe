package East_Outer_Wall;

import A_Super.Furniture;

public class Eow2_Balcony extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Eow2_Balcony() {
        super();
        this.searchable = false;
        this.description = "The second-floor balcony follows the north wall to\n"
                         + "the west and ends at a door.";
        this.searchDialog = "You're too far away to do that.";
        this.addNameKeys("(?:small )?(?:second[- ]floor )?balcony");
    }
/*----------------------------------------------------------------------------*/
}
