package Gallery;

import Super.Furniture;

public class Gal1_Pntng3 extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Pntng3(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "This one depicts a nocturnal landscape. It's painted\n"
                         + "in mostly a blue-green with trees accented in orange.\n"
                         + "The black outlining is prominent.";
        this.searchDialog = "There isn't anything unusual about this painting.";
        this.interactDialog = "You lift the painting to find a blank wall.";
        this.addActKeys("move", "take", "lift", "slide", "remove");
        this.addNameKeys("korean painting");
/*----------------------------------------------------------------------------*/
    }
}
