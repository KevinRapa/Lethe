package Observatory;

import A_Super.Furniture;
import A_Super.Unmoveable;
/**
 * @author Kevin Rapa
 */
public class Obs1_Lamp extends Furniture implements Unmoveable {
    // ========================================================================
    public Obs1_Lamp () {
        super();

        this.description = "The tall Victorian-era lamp is topped with a large\n"
                         + "glass orb holding a light bulb. It's quite bright and\n"
                         + "manages to light most of the room.";
        this.actDialog = "That light looks really hot...";

        this.addNameKeys("(?:standing )?(?:lamp|light)");
        this.addActKeys(HOLDPATTERN);
    }
    // ========================================================================   
}


