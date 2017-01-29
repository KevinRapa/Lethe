package Gallery;

import A_Super.Furniture;

public class Gal_Dome extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal_Dome() {
        super();

        this.description = "The glass dome offers a nice view of the stars.";
        this.searchDialog = "The dome is way too high up.";
        this.useDialog = 
        this.actDialog = "If you do that, the glass will probably rain\n"
                       + "rain down on you as a deadly shower of glass.";
        
        this.addUseKeys("stone block", "red ball", "cue ball", "rock");
        this.addActKeys("shatter");
        this.addNameKeys("(?:glass )?dome");
/*----------------------------------------------------------------------------*/
    }
}
