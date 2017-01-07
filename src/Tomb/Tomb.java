package Tomb;
/**
 * @author Kevin Rapa
 */
import A_Super.Room;
import A_Super.Direction;

abstract public class Tomb extends Room {
// ============================================================================    
    public Tomb(String name, String ID) {
        super(name, ID);
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        return "There is barely any room in which to move.";
    }
// ============================================================================
}