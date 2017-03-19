package Parlor;

import A_Main.Id;
import A_Super.Direction;
import A_Super.Room;
/**
 * Contains the enchanting table used to make a couple items to progress further.
 * Connects to Par2 and Bha3.
 * 
 * @see Parlor.Par1_EnchantingTable
 * @see Parlor.Par2
 * @see Back_Hall.Bha3
 * @author Kevin Rapa
 */
public class Par1 extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Par1(String name, String ID) {
        super(name, ID);
        description= 
                "A large fireplace on the south wall lights the lower "
              + "parlor, but gives off no heat. The upper balcony extends "
              + "over into the parlor on several pillars. Below it, a few "
              + "lounge chairs sit around a curious glass orb. At the "
              + "northwest corner is a door guarded by an icy barrier. In "
              + "the open area of the parlor sit a harp and cushion on a "
              + "persian rug before the hearth. A wood shelf stands at the "
              + "east, and on the west side is a table bearing a number of "
              + "etched runes and letters.";
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String getDescription() {
        if (! this.isAdjacent(Id.BHA3))
            return this.description;
        else
            return this.description.replaceFirst(", but something about it appears off", ".");
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.NORTH && ! this.isAdjacent(Id.BHA3))
            return "The door here feels ice cold and the doorknob won't turn\n"
                 + "despite your strength.";
        else 
            return bumpIntoWall();
    }
/*----------------------------------------------------------------------------*/ 
}
