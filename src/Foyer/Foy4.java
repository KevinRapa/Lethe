package Foyer;

import A_Super.Room;
import A_Super.Direction;
/**
 * @author Kevin Rapa
 */
public class Foy4 extends Room {
// ============================================================================    
    public Foy4(String name, String ID) {
        super(name, ID);
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.WEST)
            return "The staircase banister is that way.";
        else
            return bumpIntoWall();
    }
// ============================================================================
}