package Front_Balcony;

import A_Super.Column;

public class Entr_Columns extends Column {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Entr_Columns() {
        super();
        this.description = "The four-foot wide columns extend a couple stories "
                         + "up. They look like more than enough to hold up that "
                         + "roof.";

        this.addNameKeys("(?:four-foot )?(?:wide )?(?:columns?|pillars?)");
    }
/*----------------------------------------------------------------------------*/
}
