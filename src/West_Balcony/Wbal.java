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
        description = "You are on a square balcony at the front left corner of\n" +
                      "the castle. Littered all over the floor are pieces of\n" +
                      "wood. In the center stands a tall beacon of fire. To\n" +
                      "the west, you see the sea following a long cliff to\n" +
                      "a distant lighthouse. To your south, you look upon the\n" +
                      "dark forest you walked through to get here.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.WEST || dir == Direction.SOUTH)
            return "That's a couple hundred foot drop right there.";
        else
            return bumpIntoWall();
    }
/*----------------------------------------------------------------------------*/
}
