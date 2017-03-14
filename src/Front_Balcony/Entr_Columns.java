package Front_Balcony;

import A_Super.Column;

public class Entr_Columns extends Column {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Entr_Columns() {
        super();
        this.description = "The four-foot wide columns extend a couple stories\n"
                         + "up. They look like more than enough to hold up that\n"
                         + "roof.";

        this.addNameKeys("(?:four-foot )?(?:wide )?(?:columns?|pillars?)");
    }
/*----------------------------------------------------------------------------*/
}
