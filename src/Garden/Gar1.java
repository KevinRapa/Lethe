package Garden;

import A_Super.Direction;
import A_Super.Room;
/**
 * @author Kevin Rapa
 */
public class Gar1 extends Room {
//-----------------------------------------------------------------------------    
    public Gar1(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.WEST)
            return "There's about a 150 foot drop right there.";
        else
            return bumpIntoWall();
    }
//-----------------------------------------------------------------------------
}