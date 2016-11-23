package Library;

import Super.Furniture;

public class Lib2_Stat extends Furniture{

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib2_Stat(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "It's a greek statue depicting a diplomatic male.\n"
                         + "Below, a small engraving reads \"Odysseus\".";
        this.interactDialog = "You feel the statue and marvel at its detail.";
        this.addNameKeys("statue");
        this.addActKeys("touch", "feel", "grab");
    }
/*----------------------------------------------------------------------------*/
}
