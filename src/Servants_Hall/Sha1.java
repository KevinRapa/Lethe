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
    private final String DESC_2;
/*----------------------------------------------------------------------------*/
    public Sha1(String name, String ID) {
        super(name, ID);
        this.description = 
                "You're on the south end of a short dark hallway.\n" +
               "To your west is a small door. Some torches on the\n"
             + "wall dimly light the\n" +
               "hallway. Looking to the north, there's another door\n" +
               "on the left side further down the hallway. You can\n"
             + "hear a soft laughing coming from the west.";
        this.DESC_2 = 
                this.description.replaceFirst("a small door", "an open doorway");
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
            return this.DESC_2;
        else
            return this.description;
    }
/*----------------------------------------------------------------------------*/ 
}
