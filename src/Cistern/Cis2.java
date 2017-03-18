package Cistern;

import A_Super.Direction;
import Tunnels.Dungeon_Tunnel;
/**
 * Superficial.
 * @author Kevin Rapa
 */
public class Cis2 extends Dungeon_Tunnel {
// ============================================================================    
    public Cis2(String name, String ID) {
        super(name, ID);
        this.description= 
                "You are on the outer corner of the walkway. To the " +
                "north and west, you see a body of water extending " +
                "from the walkway into darkness. The bases of several " +
                "columns protruding from the stagnant water are visible and " +
                "reach into a dark void above. A canoe sits docked in the "
              + "water here. The walkway continues to the south.";
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        return "There's a large body of water that way.";
    }
// ============================================================================
}