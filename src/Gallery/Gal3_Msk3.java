package Gallery;

import Super.Furniture;

public class Gal3_Msk3 extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_Msk3() {
        super();
        this.searchable = false;
        this.description = "This mask has an avian appearance. It has a long beak,\n"
                         + "but it bears two horns as well. Below, there is a\n"
                         + "small label: \"Mossi\".";
        this.searchDialog = "The mask isn't hiding anything.";
        this.interactDialog = "You lift the mask to find a blank wall.";
        this.addActKeys("move", "take", "lift", "slide", "remove");
        this.addNameKeys("burkinabe mask");
/*----------------------------------------------------------------------------*/
    }
}
