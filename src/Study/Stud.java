package Study;

import A_Main.AudioPlayer;
import A_Super.Direction;
import A_Super.Room;
/**
 * Contains the first phylactery behind the painting, inside a safe.
 * Safe password in the Pi book.
 * Connects to Rotu.
 * 
 * @see Rotunda.Rotu
 * @see Study.Stud_BookPhylactery
 * @see Study.Stud_Safe
 * @see Study.Stud_PiBook
 * @author Kevin Rapa
 */
public class Stud extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Stud(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.SOUTH) {
            AudioPlayer.playEffect(6);
            return "The door is missing!";
        }
        else
            return bumpIntoWall(); 
    }
//-----------------------------------------------------------------------------
}
