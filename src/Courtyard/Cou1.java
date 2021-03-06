package Courtyard;

import A_Main.AudioPlayer;
import A_Super.Direction;
import A_Super.Room;
/**
 * One the plates for observatory statue puzzle can be found here in a hole.
 * 
 * @see Observatory.Obs_Slts
 * @see Courtyard.Cou1_Hl
 * @author Kevin Rapa
 */
public class Cou1 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou1(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.EAST) {
            AudioPlayer.playEffect(6);
            return "You'll need to climb the steps to get up there.";
        }
        if (dir == Direction.NORTH || dir == Direction.WEST)
            return "There's too much thorny growth to go anywhere else.";
        else 
            return bumpIntoWall();
    }
//-----------------------------------------------------------------------------
}
