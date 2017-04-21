package Caves;

import A_Super.Door;
import A_Super.Direction;
/**
 * @author Kevin Rapa
 */
public class OminousDoor extends Door {
    //-------------------------------------------------------------------------
    public OminousDoor (Direction direction) {
        super(direction);
        
        this.description = "This door is carved decoratively all over, but is "
                         + "heavily dilapidated. Much of the rock has crumbled "
                         + "off.";
    }
    //------------------------------------------------------------------------- 
}


