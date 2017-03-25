package Observatory;

import A_Super.Direction;
import A_Super.Room;

public class Obs3 extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Obs3(String name, String ID) {
        super(name, ID);
    }
/*----------------------------------------------------------------------------*/   
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.EAST)
            return "The balcony railing is that way.";
        else
            return bumpIntoWall();
    }
/*----------------------------------------------------------------------------*/
}
