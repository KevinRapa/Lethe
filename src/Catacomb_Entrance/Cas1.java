package Catacomb_Entrance;

import A_Super.Room;
import A_Super.Direction;
/**
 * @author Kevin Rapa
 */
public class Cas1 extends Room {
// ============================================================================    
    public Cas1(String name, String ID) {
        super(name, ID);
        this.description= "You are on a small balcony in a circular \n" +
                          "two-story room atop two curved staircases. The\n" +
                          "stone chamber is tinted blue from a couple of\n" +
                          "torches below burning blue flames.";
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