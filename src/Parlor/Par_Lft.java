package Parlor;

import Super.Furniture;

public class Par_Lft extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Par_Lft() {
        super();
        this.searchable = false;
        this.description = "The loft partially extends over the north wall of\n"
                         + "the first-floor parlor. In the middle, the loft bends a little\n"
                         + "further outwards.";
        this.searchDialog = "This is too big of an area to search at once.";
        this.addNameKeys("balcony", "loft", "extension");
    }
/*----------------------------------------------------------------------------*/
}
