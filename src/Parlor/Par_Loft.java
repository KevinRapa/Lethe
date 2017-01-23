package Parlor;

import A_Super.Furniture;

public class Par_Loft extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Par_Loft() {
        super();

        this.description = "The loft partially extends over the north wall of\n"
                         + "the first-floor parlor. In the middle, the loft bends a little\n"
                         + "further outwards.";
        this.searchDialog = "This is too big of an area to search at once.";
        this.addNameKeys("balcony", "loft", "extension");
    }
/*----------------------------------------------------------------------------*/
}
