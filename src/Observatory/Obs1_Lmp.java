package Observatory;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Obs1_Lmp extends Furniture {
    // ========================================================================
    public Obs1_Lmp () {
        super();
        this.searchable = false;
        
        this.description = "The tall victorian-era lamp is topped with a large\n"
                         + "glass orb holding a lightbulb. It's quite bright and\n"
                         + "manages to light most of the room.";
        this.actDialog = "That light looks really hot...";

        this.addNameKeys("(?:standing )?(?:lamp|light)");
        this.addActKeys("touch", "hold", "grab");
    }
    // ========================================================================   
}


