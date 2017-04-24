package Parlor;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Id;
import A_Super.Room;
import A_Main.Player;
import A_Super.Direction;
/**
 * Player is locked in the castle rear upon entering this room.
 * Connects to Jha1 and Par1.
 * 
 * @see Parlor.Par1
 * @see Jade_Hall.Jha1
 * @author Kevin Rapa
 */
public class Par2 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Par2(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        if (! this.isAdjacent(Id.JHA1))
            return super.getDescription()
                    .concat(" However, there is something odd about this door.");
        else
            return super.getDescription();
    }
//-----------------------------------------------------------------------------
    @Override public String triggeredEvent() {
        if (! Player.hasVisited(this.ID)) {
            AudioPlayer.playEffect(8, 0.8);
            GUI.out("After stepping into the room, the door slams shut behind you. "
                  + "Startled, you spin around and miss a breath. You are alone.");
            Player.getRoomObj(Id.FOY3).lock();
        }    
        return STD_RM_OUT;
    }
//----------------------------------------------------------------------------- 
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.SOUTH)
            return "There's nothing but a railing and open space over the lower "
                 + "level parlor.";
                
        return bumpIntoWall();
    }
//----------------------------------------------------------------------------- 
}
