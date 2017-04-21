package Observatory;

import A_Super.Direction;
import A_Super.Room;
/**
 * Holds a book describing dieties of Greek polytheism
 * 
 * @see Observatory.Obs2_Bk
 * @author Kevin Rapa
 */
public class Obs2 extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Obs2(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.WEST)
            return "The balcony railing is that way.";
        else
            return bumpIntoWall();
    }
//-----------------------------------------------------------------------------
}
