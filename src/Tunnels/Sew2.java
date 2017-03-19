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
// ============================================================================    
    public Sew2(String name, String ID) {
        super(name, ID);
        this.description= 
                "The tunnel continues to the west and east here. " +
                "The raging river of continues along the north wall. "
              + "Mounted on the south wall are a set of metal valves "
              + "with roman numerals above each. Leading out the top "
              + "of the console is a large pipe running along the "
              + "ceiling westwards. A bridge to the west crosses the "
              + "fork in the river.";
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.NORTH)
            return WATER_THAT_WAY;
        else
            return bumpIntoWall();
    }
// ============================================================================
}