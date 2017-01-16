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
        this.description= "You are on the outer corner of the walkway. To the\n" +
                          "north and west, you see a body of water extending\n" +
                          "from the walkway into darkness. The bases of several\n" +
                          "columns protruding from the stagnant water are visible and\n" +
                          "reach into a dark void above. The walkway continues\n" +
                          "to the south.";
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        return "There's a large body of water that way.";
    }
// ============================================================================
}