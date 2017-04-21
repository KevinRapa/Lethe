package Garden;

import A_Super.Furniture;
import A_Super.Gettable;
/**
 * @author Kevin Rapa
 */
public class Gar24_Sconce extends Furniture implements Gettable {
    //-------------------------------------------------------------------------
    public Gar24_Sconce () {
        super();

        this.description = "The fire burning inside the black iron sconce emits a cold yellow hue.";
        this.actDialog = "That light looks pretty hot...";

        this.addNameKeys("(?:black )?(?:iron )?(?:sconce|light)", "fire");
        this.addActKeys(GETPATTERN, HOLDPATTERN);
    }
    //------------------------------------------------------------------------- 
    @Override public String interact(String key) {
        if (key.matches(HOLDPATTERN))
            return this.actDialog;
        else
            return getIt();
    }
    //------------------------------------------------------------------------- 
}


