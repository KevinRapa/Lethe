package Chapel_Stairs;

import A_Super.Direction;
import A_Super.Staircase;
/**
 * @author Kevin Rapa
 */
public class Chs1_Stairs extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Chs1_Stairs (Direction direction, String dest) {
        super(direction, dest, 15);
        this.description = "The wide spiral stairs wind many times around the "
                         + "tower's wall. A dark red carpet follows them up.";
        this.addNameKeys("(?:circular |spiral )?stair(?:s|case)");
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        if (this.DIR == Direction.DOWN) {
            return "The spiral stairs run a few stories downward to the first "
                 + "floor landing.";
        }
        return this.description;
    }
//-----------------------------------------------------------------------------
}
