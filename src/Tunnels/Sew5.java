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
        this.description= 
                "The tunnel terminates here at the north wall. The\n" +
                  "river following the east wall continues onward through\n" +
                  "a barred gate to the north. On the west wall is a metal\n" +
                  "door with a valve next to it. The pipe on the ceiling\n"
                + "bends west and leads through the wall directly above\n" +
                  "the door. Across a small bridge to the east is another door.";
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        switch (dir) {
            case NORTH:
                return "You can't get the gate open. It's locked.";
            default:
                return bumpIntoWall();
        }
    }
// ============================================================================
}