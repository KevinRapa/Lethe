package Back_Balcony;

import Super.Furniture;

public class Bba_Drop extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bba_Drop(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "It must be at least a couple hundred feet to\n"
                         + "the bottom.";
        this.searchDialog = "You aren't sure what to do.";
        this.addNameKeys("drop");
    }
/*----------------------------------------------------------------------------*/
}
