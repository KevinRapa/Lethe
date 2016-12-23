package East_Outer_Wall;

import A_Super.Furniture;

public class Eow2_Blcny extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Eow2_Blcny() {
        super();
        this.searchable = false;
        this.description = "The second-floor balcony follows the north wall to\n"
                         + "the west and ends at a door.";
        this.searchDialog = "You're too far away to do that.";
        this.addNameKeys("balcony", "small balcony");
    }
/*----------------------------------------------------------------------------*/
}
