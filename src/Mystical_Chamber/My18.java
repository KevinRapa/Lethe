package Mystical_Chamber;

import A_Main.Id;
import A_Main.Player;
import A_Super.Room;
import Caves.Cave;
/**
 * Provides access to the caves once the player finds the iridescent jewel and
 * uses it on a pedestal in here.
 * Connects to Catacombs and Caves.
 * 
 * @see Mystical_Chamber.My18_Pedestal
 * @see Caves.Cave
 * @see Catacombs.Catacomb
 * @author Kevin Rapa
 */
public class My18 extends Room {
//-----------------------------------------------------------------------------    
    public My18(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------
    public void updateDescription() {
        this.description = 
                "You stand at the rim of the circular chamber before "
              + "the descending set of spiral stairs wrapping around "
              + "the center pillar on which the pedestal still stands.";
    }
//-----------------------------------------------------------------------------
    @Override public String triggeredEvent() {
        if (Player.getLastVisited().equals(Id.CV18))
            Cave.stopClip();
        
        return STD_RM_OUT;
    }
//-----------------------------------------------------------------------------
}