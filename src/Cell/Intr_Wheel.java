package Cell;

import static A_Main.NameConstants.METAL_BAR;
import A_Super.Furniture;
import A_Super.Heavy;
/**
 * @author Kevin Rapa
 */
public class Intr_Wheel extends Furniture implements Heavy {
    // ========================================================================
    public Intr_Wheel () {
        super();
        this.searchable = false;
        
        this.description = "The large horizontal axle spins at about shoulder\n"
                         + "height in the room. It must be somehow connected to\n"
                         + "these other gears. Be careful, you wouldn't want to\n"
                         + "bump your head on this thing.";
        
        this.actDialog = "You could never muster the strength to stop the wheel.";
        this.useDialog = "You thrust the bar into the wheel attempting to stop it. The bar jolts back along with your body.";
        this.searchDialog = "You search around the machinery but cannot find anything\n"
                          + "useful.";

        this.addUseKeys(METAL_BAR);
        this.addNameKeys("(?:large )?(?:spinning )?(?:horizontal )?(?:(?:water )?wheel|axle)");
        this.addActKeys(GETPATTERN);
        this.addActKeys("stop");
    }
    // ======================================================================== 
}


