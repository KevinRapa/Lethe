package Mystical_Chamber;

import A_Super.Direction;
import A_Super.Staircase;
/**
 * @author Kevin Rapa
 */
public class My18_Stairs extends Staircase {
    //-------------------------------------------------------------------------
    public My18_Stairs (Direction direction) {
        super(direction);
        this.description = "The sandstone spiral staircase wraps around the central "
                         + "pillar " + (direction == Direction.DOWN ? "down into "
                         + "a dark void." : "up into the round chamber.");

        this.addNameKeys("(?:sandstone )?spiral stair(?:s|case)");
    }
    //-------------------------------------------------------------------------    
}


