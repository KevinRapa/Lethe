package Foyer;

import A_Super.Direction;
import A_Super.Staircase;

public class Foy2_Strcs extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Foy2_Strcs(Direction direction) {
        super(direction);
        this.description = "A winding staircase run with red carpet all the way\n"
                         + "up. Looking straight " + direction + ", it winds around\n"
                         + "until terminating at the " + 
                            (direction == Direction.UP ? "third" : "first") + 
                            " floor, where it leads\n"
                         + "back to the south. Halfway " + direction + " is a second\n"
                         + "floor landing to the north.";
        this.searchDialog = "In searching the stairs, you find it as clean and\n"
                          + "bare as the rest of this room.";
    }
/*----------------------------------------------------------------------------*/
}
