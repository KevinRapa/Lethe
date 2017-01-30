package Parlor;

import A_Super.Balcony;

public class Par_Loft extends Balcony {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Par_Loft() {
        super();

        this.description = "The loft partially extends over the north wall of\n"
                         + "the first-floor parlor. In the middle, the loft bends a little\n"
                         + "further outwards.";

        this.addNameKeys("balcony", "loft", "extension");
    }
/*----------------------------------------------------------------------------*/
}
