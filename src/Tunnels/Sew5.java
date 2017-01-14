package Tunnels;

import A_Super.Direction;
/**
 * The end of the tunnel.
 * 
 * @author Kevin Rapa
 */
public class Sew5 extends Dungeon_Tunnel {
// ============================================================================    
    public Sew5(String name, String ID) {
        super(name, ID);
        this.description= "The tunnel terminates here at the north wall. The\n" +
                          "river following the east wall continues onward through\n" +
                          "a barred gate to the north. On the west wall is a metal\n" +
                          "door with a valve next to it. The pipe on\n"
                        + "the ceiling bends west and leads\n" +
                          "through the wall directly above the door. Across a\n" +
                          "small bridge to the east is another door.";
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        switch (dir) {
            case EAST:
                return "There's a river of water running that way.";
            case NORTH:
                return "You can't get the gate open. It's locked.";
            default:
                return bumpIntoWall();
        }
    }
// ============================================================================
}