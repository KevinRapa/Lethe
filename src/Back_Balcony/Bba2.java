package Back_Balcony;

import A_Super.Direction;
import A_Super.Room;
/**
 * Contains a note which directs player to the first key.
 * Mainly superficial, for flavor. Offers view of the village the player left
 * from.
 * Named Foyc in order to avoid door sound.
 * Connected to Gal1 and Foyb
 * 
 * @see Gallery.Gal1
 * @see Back_Balcony.Bba1
 * @see Back_Balcony.Bba_Note
 * @author Kevin Rapa
 */
public class Bba2 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bba2(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------
    @Override public String getBarrier(Direction dir) {
        switch (dir) {
            case NORTH:
                return "There's a couple hundred foot drop right there.";
            case SOUTH:
                return "You should be getting out of here..."; // For end game.
            default:
                return bumpIntoWall();
        }
    }
//-----------------------------------------------------------------------------
}
