package Black_Staircase;

import A_Main.GUI;
import A_Main.Player;
import A_Super.Room;
import A_Super.Direction;
/**
 * Superficial
 * 
 * @author Kevin Rapa
 */
public class Bls2 extends Room {
// ============================================================================    
    public Bls2(String name, String ID) {
        super(name, ID);
        this.description= "You stand on the small upper-floor balcony before a door to your east.";
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        return "The iron railing on the balcony is that way.";
    }
// ============================================================================
    @Override public String triggeredEvent() {
        if (! Player.hasVisited(ID))
            GUI.out("The throbbing in your head intensifies.");
            
        return STD_RM_OUT;
    }
}