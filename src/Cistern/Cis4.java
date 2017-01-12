package Cistern;

import A_Super.Room;
import A_Super.Direction;
/**
 * Superficial
 * @author Kevin Rapa
 */
public class Cis4 extends Room {
// ============================================================================    
    public Cis4(String name, String ID) {
        super(name, ID);
        this.description= "You have reached the end of the walkway, which only\n" +
                          "leads back north at this point. To your east is\n" +
                          "another metal door. To the west is the putrid body of water\n" +
                          "and many stone columns. Several torches on the wall\n" +
                          "light this area.";
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.WEST)
            return "There's a large body of water that way.";
        else
            return bumpIntoWall();
    }
// ============================================================================
}