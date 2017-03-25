package Catacomb_Entrance;

import A_Super.Room;
import A_Super.Direction;
/**
 * Access to catacombs, a maze complex leading to the caves.
 * Connects to Cs35 and Cry2
 * 
 * @see Crypt.Cry2
 * @see Catacomb_Entrance.Cs35
 * @see Caves.Cave
 * @see Catacombs.Catacomb
 * @author Kevin Rapa
 */
public class Cas1 extends Room {
// ============================================================================    
    public Cas1(String name, String ID) {
        super(name, ID);
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.WEST)
            return "The balcony edge is that way.";
        else
            return bumpIntoWall();
    }
// ============================================================================
}