package Library;

import A_Super.Balcony;

public class Lib_Balcony extends Balcony {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib_Balcony() {
        super();

        this.description = "The second-floor balcony follows the east wall and "
                         + "around to the south wall. On the balcony against the "
                         + "south wall is another bookshelf.";

        this.addNameKeys("(?:second[- ]floor )?balcony");
    }
/*----------------------------------------------------------------------------*/
}
