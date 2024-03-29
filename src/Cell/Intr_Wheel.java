package Cell;

import static A_Main.Names.METAL_BAR;
import A_Super.Furniture;
import A_Super.Unmoveable;
/**
 * @author Kevin Rapa
 */
public class Intr_Wheel extends Furniture implements Unmoveable {
    //-------------------------------------------------------------------------
    public Intr_Wheel () {
        super();

        this.description = "The large horizontal axle spins at about shoulder "
                         + "height in the room. It must be somehow connected to "
                         + "these other gears.";
        
        this.actDialog = "You could never muster the strength to stop the wheel.";
        this.useDialog = "You thrust the bar into the wheel attempting to stop "
                + "it. The bar jolts back along with your body.";
        this.searchDialog = "You search around the machinery but cannot find anything "
                          + "useful.";

        this.addUseKeys(METAL_BAR);
        this.addNameKeys("(?:large )?(?:spinning )?(?:horizontal )?(?:(?:water )?wheel|axle)");
        this.addActKeys(GETPATTERN, "stop");
    }
    //------------------------------------------------------------------------- 
}


