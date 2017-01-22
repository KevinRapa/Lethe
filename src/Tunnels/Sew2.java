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
        this.description= "The tunnel continues to the west and east here.\n" +
                          "The raging river of water flows eastwards against the\n" +
                          "north wall. Mounted on the south wall are a set\n" +
                          "of metal valves with roman numerals above each.\n" +
                          "Leading out the top of the valves is a large pipe\n" +
                          "running along the ceiling westwards. A bridge to the\n"
                        + "west crosses the fork in the river.";
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.NORTH)
            return "There's a river of water running that way.";
        else
            return bumpIntoWall();
    }
// ============================================================================
}