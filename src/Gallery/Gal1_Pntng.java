package Gallery;

import Super.Furniture;

public class Gal1_Pntng extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Pntng(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "This painting is highly detailed and colorful.\n"
                         + "Painted on it are many different colored Hindu\n"
                         + "deities playing musical instruments. One of them\n"
                         + "riding in a chariot resembles an elephant.";
        this.searchDialog = "There isn't anything unusual about this painting.";
        this.interactDialog = "You lift the painting to find a blank wall.";
        this.addActKeys("move", "take", "lift", "slide", "remove");
        this.addNameKeys("indian painting");
/*----------------------------------------------------------------------------*/
    }
}
