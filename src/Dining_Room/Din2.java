package Dining_Room;

import A_Super.Direction;
import A_Super.Room;
/**
 * Superficial.
 * Entrance to drawing room.
 * @author Kevin Rapa
 */
public class Din2 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Din2(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.EAST)
            return "There's a railing that way.";
        
        return bumpIntoWall();
    }
//-----------------------------------------------------------------------------
}