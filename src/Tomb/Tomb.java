package Tomb;

import A_Main.AudioPlayer;
import A_Super.Room;
import A_Super.Direction;
/**
 * There are three tomb rooms in the catacombs with keys for the casket
 * in the ancient tomb.
 * These are Asterion and Rhadamanthus' tombs, and Eurynomos' empty tomb.
 * Connects to catacombs.
 * 
 * @see Catacombs.Catacomb
 * @see Ancient_Tomb.Ant_Casket
 * @author Kevin Rapa
 */
public class Tomb extends Room {
// ============================================================================    
    public Tomb(String ID) {
        super("Small tomb", ID);
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        AudioPlayer.playEffect(6);
        return "There is barely any room in which to move.";
    }
// ============================================================================
}