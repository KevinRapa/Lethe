package Garden;

import A_Super.Furniture;
import A_Super.Gettable;
/**
 * @author Kevin Rapa
 */
public class Gar24_Sconce extends Furniture implements Gettable {
    // ========================================================================
    public Gar24_Sconce () {
        super();

        this.description = "The fire burning inside the black iron sconce emits a cold yellow hue.";
        this.actDialog = "That light looks pretty hot...";

        this.addNameKeys("(?:black )?(?:iron )?(?:sconce|light)", "fire");
        this.addActKeys(GETKEYS);
        this.addActKeys("touch", "hold", "grab");
    }
    // ======================================================================== 
    @Override public String interact(String key) {
        if (key.equals("touch") || key.equals("hold") || key.equals("grab"))
            return this.actDialog;
        else
            return getIt();
    }
    // ======================================================================== 
}


