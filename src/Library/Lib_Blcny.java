package Library;

import Super.Furniture;

public class Lib_Blcny extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib_Blcny(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "The second-floor balcony follows the east wall and\n"
                         + "around to the south wall. On the balcony against the\n"
                         + "south wall is another bookshelf.";
        this.searchDialog = "You're too far away to do that.";
        this.addNameKeys("balcony");
    }
/*----------------------------------------------------------------------------*/
}
