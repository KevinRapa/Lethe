package Forest;

import A_Super.Room;
import A_Super.Direction;
/**
 * Creates amusing dialog if the player decides to not venture towards the castle.
 * @author Kevin Rapa
 */
public class Forest extends Room {
// ============================================================================    
    public Forest(String ID) {
        super("Dark forest", ID);
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        return "There's an impenetrable thicket that way. "
                + "See? Nothing interesting! Let's go back now.";
    }
// ============================================================================
}