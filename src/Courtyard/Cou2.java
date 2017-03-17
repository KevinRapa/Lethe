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
        description= 
                "You're in the southwest section of the courtyard.\n" +
                 "What barely resembles a fountain forms the centerpiece\n" +
                 "of this area. Barely visible at your feet is a tiled\n" +
                 "walkway surrounding the fountain. Unkept bushes line\n" +
                 "the castle walls to the south and west.";
    }
/*----------------------------------------------------------------------------*/    
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.SOUTH)
            return bumpIntoWall().concat(" About 15 feet up though, you can\n"
                                    + "see a fissure in the wall of the castle.");
        else
            return bumpIntoWall();
        
    }
/*----------------------------------------------------------------------------*/
}
