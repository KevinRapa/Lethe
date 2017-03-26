package West_Outer_Wall;

import static A_Main.Names.CROWBAR;
import A_Super.Direction;
import A_Super.Door;

public class Wow2_Door extends Door {
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Wow2_Door (Direction dir) {
        super(dir);
        this.description = "To your east, you inspect the door. It's in horrible "
                         + "condition. It's boarded shut, and numerous gashes and "
                         + "splinters cover it. A hole in the door is big enough "
                         + "to see through.";
        this.useDialog = "You've been in there already. Is it really worth expending the energy?";
        this.actDialog = "Not even someone as burly as yourself could pull these "
                            + "boards off.";
        this.addNameKeys("hole", "(?:wood(?:en)?)?boards?");
        this.addUseKeys(CROWBAR);
        this.addActKeys("pry", "remove");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        if (key.equals("pry") || key.equals("remove"))
            return this.actDialog;
        else
            return super.interact(key);
    }
/*----------------------------------------------------------------------------*/
}