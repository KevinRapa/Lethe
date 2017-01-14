package Cell;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Intr_Whl extends Furniture {
    // ========================================================================
    public Intr_Whl () {
        super();
        this.searchable = false;
        
        this.description = "The large horizontal axle spins at about shoulder\n"
                         + "height in the room. It must be somehow connected to\n"
                         + "these other gears. Be careful, you wouldn't want to\n"
                         + "bump your head on this thing.";
        
        this.actDialog = "You could never muster the strength to stop the wheel.";
        this.searchDialog = "You search around the machinery but cannot find anything\n"
                          + "useful.";

        this.addNameKeys("(?:large )?(?:spinning )?(?:horizontal )?(?:(?:water )?wheel|axle)");
        this.addActKeys("stop");
    }
    // ========================================================================    
}


