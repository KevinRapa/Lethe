package Garden;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Gar2_Dome extends Furniture {
    // ========================================================================
    public Gar2_Dome () {
        super();

        this.description = "The paneled dome must be there to prevent rain from\n"
                         + "dripping into the room below. Still, why have a hole\n"
                         + "there in the first place?";
        this.useDialog = 
        this.actDialog = "If you do that, the glass will probably rain\n"
                       + "rain down on you as a deadly shower of glass.";

        this.addUseKeys("stone block", "red ball", "cue ball", "rock");
        this.addActKeys("shatter");
        this.addNameKeys("(?:paneled )?(?:glass )?dome");
    }
    // ======================================================================== 
}


