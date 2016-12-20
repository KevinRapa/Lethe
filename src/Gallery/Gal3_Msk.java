package Gallery;

import Super.Furniture;

public class Gal3_Msk extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_Msk() {
        super();
        this.searchable = false;
        this.description = "This mask freaks you out. It is uncannily long with\n"
                         + "a slender nose almost reaching its chin. It has no\n"
                         + "mouth and only two tiny eye holes.";
        this.searchDialog = "The mask isn't hiding anything.";
        this.interactDialog = "You lift the mask to find a blank wall.";
        this.addActKeys("move", "take", "lift", "slide", "remove");
        this.addNameKeys("gabonese mask");
/*----------------------------------------------------------------------------*/
    }
}
