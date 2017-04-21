package Gallery;

import A_Super.Furniture;

public class Gal1_Paintings extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Paintings() {
        super();
        this.searchable = false;
        this.description = "You quickly browse around the paintings in the room. "
                         + "You find:\t\t\t"
                         + "<> A Tibetan painting\t\t"
                         + "<> An Indian painting\t\t"
                         + "<> A Korean painting\t\t"
                         + "<> A Chinese scroll";
        this.searchDialog = "You aren't sure which one to search first.";
        this.actDialog = "You aren't sure which one to move.";
        this.addActKeys(GETPATTERN);
        this.addActKeys("move", "lift", "slide");
        this.addNameKeys("painting", "paintings");
//-----------------------------------------------------------------------------
    }
}
