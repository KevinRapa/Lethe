package Gallery;

import Super.Furniture;

public class Gal1_Pntngs extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Pntngs(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "You quickly browse around the paintings in the room.\n"
                         + "You find:\n"
                         + "-- A Tibetan painting\n"
                         + "-- An Indian painting\n"
                         + "-- A Korean painting\n"
                         + "-- A Chinese scroll";
        this.searchDialog = "You aren't sure which one to search first.";
        this.interactDialog = "You aren't sure which one to move.";
        this.addActKeys("move", "take", "lift", "slide", "remove");
        this.addNameKeys("painting", "paintings");
/*----------------------------------------------------------------------------*/
    }
}
