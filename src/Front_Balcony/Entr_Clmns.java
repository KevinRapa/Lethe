package Front_Balcony;

import A_Super.Furniture;

public class Entr_Clmns extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Entr_Clmns() {
        super();
        this.searchable = false;
        this.description = "The four-foot wide columns extend a couple stories\n"
                         + "up. They look like more than enough to hold up that\n"
                         + "roof.";
        this.actDialog = "These columns don't need extra help holding up the roof.";
        this.addActKeys("grab", "touch", "hold");
        this.addNameKeys("(?:four-foot )?(?:wide )?columns?");
    }
/*----------------------------------------------------------------------------*/
}
