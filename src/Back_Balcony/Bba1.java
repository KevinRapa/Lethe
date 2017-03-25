package Back_Balcony;

import A_Main.AudioPlayer;
import A_Super.Room;
import A_Super.Direction;
/**
 * Contains a note which directs player to the first key.
 * Mainly superficial, for flavor. Offers view of the village the player left
 * from. 
 * Named Foyb in order to avoid door noise.
 * Connects to Foy2 and Foyc.
 * 
 * @see Back_Balcony.Bba2
 * @see Foyer.Foy2
 * @see Back_Balcony.Bba_Note
 * @author Kevin Rapa
 */
public class Bba1 extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bba1(String name, String ID) {
        super(name, ID);
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(Direction dir) {
        switch (dir) {
            case NORTH:
                return "There's a couple hundred foot drop right there.";
            case SOUTH:
                AudioPlayer.playEffect(4);
                return "The gate that way is closed.";
            default:
                return bumpIntoWall();
        }
    }
/*----------------------------------------------------------------------------*/
}
