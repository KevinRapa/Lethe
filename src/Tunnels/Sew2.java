package Tunnels;

import A_Super.Direction;
/**
 * Contains the valves used to give access to the ancient cistern.
 * 
 * @author Kevin Rapa
 */
public class Sew2 extends Dungeon_Tunnel {
// ============================================================================    
    public Sew2(String name, String ID) {
        super(name, ID);
        this.description= "The tunnel keeps on going to the west and to the east.\n" +
                          "To the north, the raging river of water\n" +
                          "flows eastwards. Mounted on the south wall are a set\n" +
                          "of metal valves with roman numerals above each.\n" +
                          "Leading out the top of the valves is a large pipe\n" +
                          "leading along the ceiling to the west. A bridge to the\n"
                        + "west leads over the fork in the river.";
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