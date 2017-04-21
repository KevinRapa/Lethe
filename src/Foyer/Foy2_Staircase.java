package Foyer;

import A_Super.Direction;
import A_Super.Staircase;

public class Foy2_Staircase extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Foy2_Staircase(Direction direction) {
        super(direction);
        this.description = "A winding staircase run with red carpet all the way "
                         + "up. Looking straight " + direction + ", it winds around "
                         + "until terminating at the " + 
                            (direction == Direction.UP ? "third" : "first") + 
                            " floor, where it leads "
                         + "back to the south. Halfway " + direction + " is a second "
                         + "floor landing to the north.";
        this.searchDialog = "In searching the stairs, you find it as clean and "
                          + "bare as the rest of this room.";
    }
//-----------------------------------------------------------------------------
}
