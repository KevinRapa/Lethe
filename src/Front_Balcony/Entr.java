package Front_Balcony;

import A_Super.Direction;
import A_Super.Room;
/**
 * Superficial.
 * Front entrance of the castle.
 * 
 * @author Kevin Rapa
 */
public class Entr extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Entr(String name, String ID) {
        super(name, ID);
    }  
/*----------------------------------------------------------------------------*/        
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.EAST || dir == Direction.WEST)
            return "There's just a railing that way.";
        
        return "There's a wall in the way.";
    }
/*----------------------------------------------------------------------------*/
}
