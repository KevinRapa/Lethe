package Cell;

import static A_Main.NameConstants.METAL_BAR;
import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Intr_Gears extends Furniture {
    // ========================================================================
    public Intr_Gears () {
        super();
        this.searchable = false;
        
        this.description = "Many gears and axles of different sizes spin on the\n"
                         + "walls. They must generate power for something.";
        this.actDialog = "You don't think sticking your hand in there is a good idea.";
        this.useDialog = "You thrust the bar into the gears. The bar bounces off, ineffective. Your body jolts back.";
        this.searchDialog = "You search around the machinery but cannot find anything\n"
                          + "useful.";

        this.addNameKeys("(?:spinning )?gears", "machinery", "axles");
        this.addActKeys("touch", "feel", "stop");
        this.addUseKeys(METAL_BAR);
    }
    // ========================================================================  
}


