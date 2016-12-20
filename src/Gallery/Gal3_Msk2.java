package Gallery;

import Super.Furniture;

public class Gal3_Msk2 extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_Msk2() {
        super();
        this.searchable = false;
        this.description = "This mask has an interesting comb structure on top.\n"
                         + "It has no mouth, but a long slender nose. Below, you\n"
                         + "see a small label: \"Bambara\".";
        this.searchDialog = "The mask isn't hiding anything.";
        this.interactDialog = "You lift the mask to find a blank wall.";
        this.addActKeys("move", "take", "lift", "slide", "remove");
        this.addNameKeys("malian mask");
/*----------------------------------------------------------------------------*/
    }
}
