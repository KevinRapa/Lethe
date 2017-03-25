package Gallery;

import A_Super.Direction;
import A_Super.Room;

public class Gal6 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal6(String name, String ID) {
        super(name, ID);
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.EAST)
            return "There's just open space that way. Wouldn't want to fall.";
        else 
            return bumpIntoWall();
    }
/*----------------------------------------------------------------------------*/
}