package Courtyard;

import A_Super.Direction;
import A_Super.Room;
/**
 * Superficial.
 * @author Kevin Rapa
 */
public class Cou2 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou2(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------    
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.SOUTH)
            return bumpIntoWall().concat(" About 15 feet up though, you can "
                                    + "see a fissure in the wall of the castle.");
        else
            return bumpIntoWall();
        
    }
//-----------------------------------------------------------------------------
}
