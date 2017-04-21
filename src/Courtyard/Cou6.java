package Courtyard;

import A_Main.AudioPlayer;
import A_Super.Direction;
import A_Super.Room;
/**
 * Contains the ghost that plays blackjack.
 * 
 * @see Courtyard.Cou6_BlackJackGhost
 * @author Kevin Rapa
 */
public class Cou6 extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou6(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.WEST) {
            AudioPlayer.playEffect(6);
            return "You'll need to climb the steps to get up there.";
        }
        if (dir == Direction.NORTH || dir == Direction.EAST)
            return "There's too much thorny growth to go anywhere else.";
        else 
            return bumpIntoWall();
    }
//-----------------------------------------------------------------------------
}