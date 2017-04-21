package Tunnels;

import A_Super.Direction;
/**
 * Contains the valves used to give access to the ancient cistern.
 * Connects to Sew1 and Sew3
 * 
 * @see Tunnels.Sew3
 * @see Tunnels.Sew1
 * @see Tunnels.Sew2_Valves
 * @author Kevin Rapa
 */
public class Sew2 extends Dungeon_Tunnel {
//-----------------------------------------------------------------------------    
    public Sew2(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.NORTH)
            return WATER_THAT_WAY;
        else
            return bumpIntoWall();
    }
//-----------------------------------------------------------------------------
}