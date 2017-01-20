package Chapel_Stairs;

import A_Main.Id;
import A_Main.Player;
import A_Super.Direction;
import A_Super.Staircase;

public class Chs1_Strs extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Chs1_Strs (Direction direction) {
        super(direction);
        this.description = "The wide spiral stairs wind many times around the\n"
                         + "tower's wall. A dark red carpet follows them up.";
        this.addNameKeys("(?:circular |spiral )?stair(?:s|case)");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (this.DIR == Direction.DOWN) {
            return "The spiral stairs run a few stories downward to the first\n"
                 + "floor landing.";
        }
        return this.description;
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {     
        playEffect();
        
        if (DIR == Direction.UP)
            Player.setOccupies(Id.CHS3);
        else
            Player.setOccupies(Id.CHS1);
        
        return "You climb " + DIR + " the stairs.";
    }
/*----------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------*/
}
