package Attic;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Id;
import A_Main.Player;
import A_Super.Room;
/**
 * The player is captured in ATT1 after creating the phase door potion.
 *
 * @author Kevin Rapa
 */
public class Att2 extends Room {
// ============================================================================    
    public Att2(String name, String ID) {
        super(name, ID);
    }
// ============================================================================
    @Override public String triggeredEvent() {
        if (! Player.hasVisited(Id.ATT2)) {
            AudioPlayer.playEffect(52);
            GUI.out("You feel an unnerving presence here. You shutter and look "
                  + "around, but see only darkness.");
        }
        
        return this.STD_RM_OUT;
    }
// ============================================================================
}