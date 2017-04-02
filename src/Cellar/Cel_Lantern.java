package Cellar;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Cel_Lantern extends Furniture {

    // ========================================================================
    public Cel_Lantern () {
        super();
        
        this.description = "The small octogonal gas lamp hangs from a chain "
                + "connected to the ceiling. It lights the area is a dim orange "
                + "hue.";
        this.actDialog = "The lantern is connected to a chain on the ceiling and "
                + "can't be moved.";

        this.addNameKeys("(?:small )?(?:octogonal )?(?:hanging )?(?:lantern|lamp)");
        this.addActKeys(GETPATTERN);
    }
    // ========================================================================    
}


