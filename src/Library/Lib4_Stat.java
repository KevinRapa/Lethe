package Library;

import Super.Furniture;

public class Lib4_Stat extends Furniture{

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib4_Stat(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "It's a statue depicting some kind of horned demon.\n"
                         + "Below, a small engraving reads \"Lucifer\".";
        this.interactDialog = "You feel the statue and marvel at its detail.";
        this.addNameKeys("statue");
        this.addActKeys("touch", "grab", "feel");
    }
/*----------------------------------------------------------------------------*/
}
