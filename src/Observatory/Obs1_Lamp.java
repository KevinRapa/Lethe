package Observatory;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Obs1_Lamp extends Furniture {
    // ========================================================================
    public Obs1_Lamp () {
        super();

        this.description = "The tall victorian-era lamp is topped with a large\n"
                         + "glass orb holding a lightbulb. It's quite bright and\n"
                         + "manages to light most of the room.";
        this.actDialog = "That light looks really hot...";

        this.addNameKeys("(?:standing )?(?:lamp|light)");
        this.addActKeys(HOLDPATTERN);
    }
    // ========================================================================   
}


