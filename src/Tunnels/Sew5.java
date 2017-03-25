package Tunnels;

import A_Super.Direction;
/**
 * The end of the tunnel, contains valve to drain toxic gas from Cis1.
 * Connects to Cis1, Pris, and Sew4
 * 
 * @see Prison.Pris
 * @see Cistern.Cis1
 * @see Tunnels.Sew4
 * @author Kevin Rapa
 */
public class Sew5 extends Dungeon_Tunnel {
// ============================================================================    
    public Sew5(String name, String ID) {
        super(name, ID);
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.NORTH)
            return "You can't get the gate open. It's locked.";
        else
            return bumpIntoWall();
    }
// ============================================================================
}