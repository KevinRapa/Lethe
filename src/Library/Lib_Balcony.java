package Library;

import A_Super.Furniture;

public class Lib_Balcony extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib_Balcony() {
        super();

        this.description = "The second-floor balcony follows the east wall and\n"
                         + "around to the south wall. On the balcony against the\n"
                         + "south wall is another bookshelf.";
        this.searchDialog = "You're too far away to do that.";
        this.addNameKeys("(?:second[- ]floor )?balcony", "railing");
    }
/*----------------------------------------------------------------------------*/
}
