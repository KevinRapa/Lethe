package West_Balcony;

import A_Super.Direction;
import A_Super.Room;
/**
 * The wooden rod for the fixed ladder can be found on the floor here.
 * Connects to Wow1.
 * 
 * @see West_Outer_Wall.Wow1
 * @author Kevin Rapa
 */
public class Wbal extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wbal(String name, String ID) {
        super(name, ID);
        description = 
                "You are on a square balcony at the front west corner of " +
                "the castle. Littered all over the floor are pieces of " +
                "wood and debris. In the center stands a tall beacon. To " +
                "the west, the ocean follows a long cliff to a distant "
              + "lighthouse. To your south, you look upon the dark forest "
              + "you walked through to get here.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.WEST || dir == Direction.SOUTH)
            return "There's a couple hundred foot drop right there.";
        else
            return bumpIntoWall();
    }
/*----------------------------------------------------------------------------*/
}
