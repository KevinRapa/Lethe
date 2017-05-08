package Cell;

import static A_Main.Names.METAL_BAR;
import A_Super.Furniture;
import A_Super.Gettable;
import A_Super.Unmoveable;
/**
 * @author Kevin Rapa
 */
public class Intr_Gears extends Furniture implements Gettable, Unmoveable {
    //-------------------------------------------------------------------------
    public Intr_Gears () {
        super();

        this.description = "Many gears and axles of different sizes spin on the "
                         + "walls. They must generate power for something.";
        this.actDialog = "You don't think sticking your hand in there is a good idea.";
        this.useDialog = "You thrust the bar into the gears. The bar bounces off, ineffective. Your body jolts back.";
        this.searchDialog = "You search around the machinery but cannot find anything useful.";

        this.addNameKeys("(?:spinning )?gears?", "machinery", "axles");
        this.addActKeys(GETPATTERN, "touch|feel|stop");
        this.addUseKeys(METAL_BAR);
    }
    //-------------------------------------------------------------------------  
    @Override public String interact(String key) {
        if (key.matches("touch|feel|stop"))
            return this.actDialog;
        else
            return getIt();
    }
    //-------------------------------------------------------------------------  
}


