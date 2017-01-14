package Cell;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Intr_Grs extends Furniture {
    // ========================================================================
    public Intr_Grs () {
        super();
        this.searchable = false;
        
        this.description = "Many gears and axles of different sizes spin on the\n"
                         + "walls. They must generate power for something.";
        this.actDialog = "You don't think sticking your hand in there is a good idea.";
        this.searchDialog = "You search around the machinery but cannot find anything\n"
                          + "useful.";

        this.addNameKeys("(?:spinning )?gears", "machinery", "axles");
        this.addActKeys("touch", "feel", "stop");
    }
    // ========================================================================  
}


