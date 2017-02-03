package Gallery;

import static A_Main.NameConstants.*;
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
        
        this.addUseKeys(STONE_BLOCK, RED_BALL, CUE_BALL, ROCK);
        this.addActKeys("shatter");
        this.addNameKeys("(?:glass )?dome");
/*----------------------------------------------------------------------------*/
    }
}
