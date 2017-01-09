package Tomb;
/**
 * @author Kevin Rapa
 */
import A_Main.AudioPlayer;
import A_Super.Room;
import A_Super.Direction;

abstract public class Tomb extends Room {
// ============================================================================    
    public Tomb(String ID) {
        super("in a small tomb", ID);
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        AudioPlayer.playEffect(6);
        return "There is barely any room in which to move.";
    }
// ============================================================================
}