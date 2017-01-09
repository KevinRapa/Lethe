package Mystical_Chamber;

import A_Super.Direction;
import A_Super.Staircase;
/**
 * @author Kevin Rapa
 */
public class My18_Strs extends Staircase {

    // ========================================================================
    public My18_Strs (Direction direction) {
        super(direction, 1);
        this.description = "The sandstone spiral staircase wraps around the central\n"
                         + "pillar " + (direction == Direction.DOWN ? "down into\n"
                         + "a dark void." : "up into the round chamber.");

        this.addNameKeys("(?:sandstone )?spiral stair(?:s|case)");
    }
    // ========================================================================    
}


