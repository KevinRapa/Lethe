package Caves;

import A_Super.Door;
import A_Super.Direction;
/**
 * @author Kevin Rapa
 */
public class OmnDr extends Door {
    // ========================================================================
    public OmnDr (Direction direction) {
        super(direction);
        
        this.description = "This door is carved decoratively all over, but is\n"
                         + "heavily dilapidated. Much of the rock has crumbled\n"
                         + "off.";
    }
    // ======================================================================== 
}


