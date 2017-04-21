package Chapel_Stairs;

import A_Super.Direction;
import A_Super.Room;
/**
 * Serves as the entrance to the chapel.
 * Superficial.
 * 
 * @author Kevin Rspa
 */
public class Chs3 extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Chs3(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.WEST)
            return "The landing's railing protects you from tumbling three stories.";
        else
            return bumpIntoWall();
    }
//-----------------------------------------------------------------------------
}