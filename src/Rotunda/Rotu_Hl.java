package Rotunda;

import Super.Furniture;

public class Rotu_Hl extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rotu_Hl(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "It's a hole carved in the ceiling, about a meter\n"
                         + "wide. It looks to lead outside to the roof, although\n"
                         + "there's a glass encasing around the space above.";
        this.searchDialog = "The hole is but empty space. You have nothing to\n"
                          + "search";
        this.addNameKeys("hole");
    }
/*----------------------------------------------------------------------------*/
}
