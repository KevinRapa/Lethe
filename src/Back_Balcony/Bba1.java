package Back_Balcony;

import A_Super.Room;
import A_Super.Direction;
/**
 * Contains a note which directs player to the first key.
 * Mainly superficial, for flavor. Offers view of the village the player left
 * from.
 * 
 * @see Back_Balcony.Bba_Note
 * @author Kevin Rapa
 */
public class Bba1 extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bba1(String name, String ID) {
        super(name, ID);
        description= "A balcony behind the castle extends to your east. A stone\n" +
                     "railing lining the edge sprouts columns which hold a roof\n" +
                     "over your head. The balcony is bare except for a sconce\n" +
                     "lighting it dimly and a stone bench to your left. Far below,\n" +
                     "there is an immense drop to the the sea where waves crash\n" +
                     "against the cliff. The sea extends northwards and to the\n" +
                     "west indefinitely, but to the east, you can see the village\n" +
                     "you left from behind a shoreline.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.NORTH)
            return "There's a couple hundred foot drop right there.";
        else {
            return bumpIntoWall();
        }
    }
/*----------------------------------------------------------------------------*/
}
