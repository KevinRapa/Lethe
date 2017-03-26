package Gallery;

import A_Super.Furniture;

public class Gal3_Hole extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_Hole() {
        super();

        this.description = "The rope feeds into the small hole. Around the hole "
                         + "is a metal lip. This was likely installed recently.";
        this.searchDialog = "You peek into the hole, and see only the rope fade into "
                          + "the dark.";
        this.addNameKeys("hole");
/*----------------------------------------------------------------------------*/
    }
}
