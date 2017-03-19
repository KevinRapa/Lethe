package Cistern;

import A_Super.Direction;
import Tunnels.Dungeon_Tunnel;
/**
 * Superficial.
 * @author Kevin Rapa
 */
public class Cis3 extends Dungeon_Tunnel {
// ============================================================================    
    public Cis3(String name, String ID) {
        super(name, ID);
        this.description= 
                "You are halfway down the walkway inside the large\n" +
                "cistern. To your west is the large putrid body of water\n" +
                "and many columns. To the east is a metal door. The\n" +
                "walkway still continues south. Several torches on\n" +
                "the wall light this area.";
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.WEST)
            return WATER_THAT_WAY;
        else
            return bumpIntoWall();
    }
// ============================================================================
}