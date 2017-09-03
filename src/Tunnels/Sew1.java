package Tunnels;

import A_Super.Direction;
/**
 * River here contains pipe piece.
 * Connects to Sew0 and Sew2
 * 
 * @see Tunnels.Sew0
 * @see Tunnels.Sew2
 * @see Tunnels.DungeonMonster
 * @author Kevin Rapa
 */
public class Sew1 extends Dungeon_Tunnel {
//-----------------------------------------------------------------------------    
    public Sew1(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------
    @Override public String getBarrier(Direction dir) {
        switch (dir) {
            case NORTH:
                return WATER_THERE;
            case EAST:
                return "You can't get the gate open. It's locked.";
            default:
                return bumpIntoWall();
        }
    }
//-----------------------------------------------------------------------------
}