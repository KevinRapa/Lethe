package Cistern;

import A_Super.Direction;
import Tunnels.Dungeon_Tunnel;
/**
 * Superficial.
 * @author Kevin Rapa
 */
public class Cis2 extends Dungeon_Tunnel {
//-----------------------------------------------------------------------------    
    public Cis2(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------
    @Override public String getBarrier(Direction dir) {
        return WATER_THERE;
    }
//-----------------------------------------------------------------------------
}