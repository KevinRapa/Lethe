package Foyer;

import A_Super.Direction;
import A_Super.Room;
/**
 * Second floor landing of the foyer stairs.
 * 
 * @author Kevin Rapa
 */
public class Foy3 extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Foy3(String name, String ID) {
        super(name, ID);
        this.description = "You stand atop the first flight of steps on the\n"
                         + "front staircase. The stairs continue a flight up\n"
                         + "in the opposite direction. The landing is bare and\n"
                         + "only a door to your west is of interest.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.WEST)
            return "You should be getting out of here..."; // For end game.
        else
            return bumpIntoWall();
    }
/*----------------------------------------------------------------------------*/
}
