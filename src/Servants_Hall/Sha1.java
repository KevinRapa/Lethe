package Servants_Hall;

import A_Super.Direction;
import A_Super.Room;
/**
 * Adjacent to the Ransacked Quarters, where the study key is.
 * Connects to Sha2, Wow1, and Rqua
 * 
 * @see Servants_Hall.Sha2
 * @see West_Outer_Wall.Wow1
 * @see Ransacked_Quarters.Rqua
 * @author Kevin Rapa
 */
public class Sha1 extends Room {
/*----------------------------------------------------------------------------*/
    public Sha1(String name, String ID) {
        super(name, ID);
        this.description = "You're on the south end of a short dark hallway.\n" +
                           "To your west is a small door with the doorknob\n" +
                           "broken off. Some torches on the wall dimly light the\n" +
                           "hallway. Looking to the north, there's another door\n" +
                           "on the left side further down the hallway.";
    }
/*----------------------------------------------------------------------------*/        
    @Override public String getBarrier(Direction dir) {   
        if (dir == Direction.WEST)
            return "This door's knob is missing.";
        else 
            return bumpIntoWall();
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String getDescription() {
        if (! this.hasFurniture("west door"))
            return "You're on the south end of a short dark hallway.\n" +
                   "To your west is an open doorway to the next room over. A\n" +
                   "torch on the wall dimly lights the hallway. Looking\n" +
                   "to the north, there's another door on the left side\n" +
                   "further down the hallway.";
        else
            return this.description;
    }
/*----------------------------------------------------------------------------*/ 
}
