package Secret_Stairs;

import A_Super.Direction;
import A_Super.Staircase;

public class Sst_Stairs extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Sst_Stairs(Direction direction, String dest) {
        super(direction, dest, 14);
        this.description = "The rickety U-shaped wooden staircase wraps around "
                         + "the room to a small second-floor landing. It looks "
                         + "only partially stable.";
        this.addNameKeys("(?:rickety )?(?:wooden )?(?:stair(?:s|case)|steps)");
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        if (this.DIR == Direction.DOWN) {
            return "The rickety wooden stairs lead back down to the second floor.";
        }
        return this.description;
    }
//-----------------------------------------------------------------------------
}


