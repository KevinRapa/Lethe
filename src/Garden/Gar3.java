package Garden;

import A_Super.Direction;
import A_Super.Room;
/**
 * @author Kevin Rapa
 */
public class Gar3 extends Room {
// ============================================================================    
    public Gar3(String name, String ID) {
        super(name, ID);
        this.description= "You're at the southwest quarter of the garden overlooking\n" +
                          "the vast expanse of sea hugging the cliff to the south.\n"
                        + "Against the west railing is a\n" +
                          "long planter containing a bed of soil and a small variety\n" +
                          "of plants. To the northeast, in the garden's center, sits \n" +
                          "a fountain spouting water against the column supporting\n" +
                          "the glass dome. Behind you to the south is a small wooden\n" +
                          "utility chest.";
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.WEST)
            return "There's about a 150 foot drop right there.";
        else
            return bumpIntoWall();

    }
// ============================================================================
}