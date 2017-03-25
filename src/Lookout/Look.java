package Lookout;

import A_Main.AudioPlayer;
import A_Super.Direction;
import A_Super.Room;
/**
 * Location of the valve that drains the rotunda fountain.
 * Connects to Rotu
 * 
 * @see Rotunda.Rotu_Fountain
 * @see Lookout.Look_Valve
 * @see Rotunda.Rotu
 * @author Kevin Rapa
 */
public class Look extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Look(String name, String ID) {
        super(name, ID);
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(Direction dir) {
        switch (dir) {
            case WEST:
                return "There's a couple hundred foot drop right there.";
            case EAST:
                AudioPlayer.playEffect(6);
                return "The door is missing!";
            default:
                return bumpIntoWall();
        }
    }
/*----------------------------------------------------------------------------*/
}
