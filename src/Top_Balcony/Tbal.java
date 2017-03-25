package Top_Balcony;

import A_Super.Room;
import A_Super.Direction;
/**
 * Superficial room, serves as access to the soul chamber.
 * Connects to Soul and Tow2
 * 
 * @see Tower.Tow2
 * @see Soul_Chamber.Soul
 * @author Kevin Rapa
 */
public class Tbal extends Room {
// ============================================================================    
    public Tbal(String name, String ID) {
        super(name, ID);
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        return "The balcony railing is that way. It's a long drop to the sea.";
    }
// ============================================================================
}
