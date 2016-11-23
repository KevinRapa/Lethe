package Gallery;

import Super.Furniture;

public class Gal3_Hl extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_Hl(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "The rope feeds into the small hole. Around the hole\n"
                         + "is a metal lip. This was likely installed recently.";
        this.searchDialog = "You peek into the hole, and see only the rope fade into\n"
                          + "the dark.";
        this.addNameKeys("hole");
/*----------------------------------------------------------------------------*/
    }
}
