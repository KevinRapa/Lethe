package West_Antechamber;

import A_Main.AudioPlayer;
import A_Super.Direction;
import A_Super.Room;
/**
 * Contains a hidden lever that can be pulled to rotate the rotunda.
 * Room description doesn't refer to lever. Player can assume one is there
 * because there are one's in Stud, Look, and Iha1.
 * 
 * @see West_Antechamber.Want_Lever
 * @see Rotunda.Rotu
 * @author Kevin Rapa
 */
public class Want extends Room {
//-----------------------------------------------------------------------------    
    public Want(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------        
    @Override public String getBarrier(Direction dir) {
        switch (dir) {
            case WEST:
                AudioPlayer.playEffect(6);  // If the rotunda has rotated.
                return "The door is missing!";
            case EAST:
                AudioPlayer.playEffect(4);  // If the foyer gate is closed.
                return "The gate that way is closed.";
            default:
                return bumpIntoWall();
        }
    }
//-----------------------------------------------------------------------------
}
