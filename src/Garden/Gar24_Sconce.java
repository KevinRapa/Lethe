package Garden;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Gar24_Sconce extends Furniture {
    // ========================================================================
    public Gar24_Sconce () {
        super();

        this.description = "The fire burning inside the black iron sconce emits a cold yellow hue.";
        this.actDialog = "That light looks pretty hot...";

        this.addNameKeys("(?:black )?(?:iron )?(?:sconce|light)");
        this.addActKeys("touch", "hold", "grab");
    }
    // ======================================================================== 
}


