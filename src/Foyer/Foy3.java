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
    }
//-----------------------------------------------------------------------------
    @Override public String getBarrier(Direction dir) {
        switch (dir) {
            case WEST:
                return "You should be getting out of here..."; // For end game.
            case SOUTH:
                return "You aren't sure whether to go up or down.";
            default:
                return bumpIntoWall();
        }
    }
//-----------------------------------------------------------------------------
}
